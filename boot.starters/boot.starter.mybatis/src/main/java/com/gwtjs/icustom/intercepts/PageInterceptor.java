package com.gwtjs.icustom.intercepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;
import com.gwtjs.icustom.intercepts.PageInterceptor;
import com.gwtjs.icustom.intercepts.ProgramInterceptor;
import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class PageInterceptor implements Interceptor {

	/** 查询count的sql后缀 */
	private static final String COUNT_SQL_FIX = "Count";

	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(PageInterceptor.class);

	/** 数据连接 */
	private static final Log statementLog = LogFactory
			.getLog(PageInterceptor.class);

	private static final int MAPPED_STATEMENT_INDEX = 0;

	private static final int PARAMETER_INDEX = 1;

	private static final int ROW_BOUNDS_INDEX = 2;

	private static final int RESULT_HANDLER_INDEX = 3;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] queryArgs = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
		String sqlId = mappedStatement.getId();

		Executor executor = (Executor) invocation.getTarget();
		Object param = queryArgs[PARAMETER_INDEX];
		// 检查是否需要拦截，如果需要，那么返回page对象
		PageVO page = checkInvocation(sqlId, param);

		// 如果没有分页参数就直接返回
		if (null == page) {
			return invocation.proceed();
		}
		if (null != param && Map.class.isAssignableFrom(param.getClass())) {
			log.info("sql id:", sqlId);
			queryCount(queryArgs, mappedStatement, sqlId, page, executor);
		}
		// 查询结果集处理
		List entityList = new ArrayList<>();
		// 如果总数count >0 才去查询列表sql语句
		if (page.getTotalRows() > 0) {
			// 查询结果集处理
			entityList = queryentityList(executor, mappedStatement, queryArgs);
			// 异步只取结果集时修正记录总数
			if (entityList.size() > page.getTotalRows()) {
				page.setTotalRows(entityList.size());
			}
		}

		PagedResult<?> pagedResult = new PagedResult<>();
		pagedResult.setPageVO(page);
		pagedResult.setResult(entityList);

		// 将PagedResult对象包装成list返回（MyBatis的查询结果，均为List）
		List<PagedResult<?>> returnentityList = new ArrayList<PagedResult<?>>();
		returnentityList.add(pagedResult);
		return returnentityList;
	}

	/**
	 * 查询COUNT
	 * 
	 * @author aGuang
	 * @since 2012-6-11
	 * @param queryArgs
	 * @param mappedStatement
	 * @param sqlId
	 * @param pageVO
	 * @param executor
	 * @throws SQLException
	 */
	private void queryCount(Object[] queryArgs,
			MappedStatement mappedStatement, String sqlId, PageVO pageVO,
			Executor executor) throws SQLException {
		// 按命名规则,查count的sql为原sql ID + Count
		String queryCountSqlId = sqlId + COUNT_SQL_FIX;
		Configuration configuration = mappedStatement.getConfiguration();

		// 重新构建查询count所需要的变量
		MappedStatement queryCountMs = configuration
				.getMappedStatement(queryCountSqlId);

		// modified by richard
		ProgramInterceptor pi = new ProgramInterceptor();
		MappedStatement newStatement = pi.buildMappedStatement(queryCountMs);

		// 查询count，并设置到pageVO中
		List<?> queryCountList = queryentityList(executor, newStatement,
				queryArgs);
		int totalRows = Integer.parseInt(queryCountList.get(0).toString());
		pageVO.setTotalRows(totalRows);
	}

	/**
	 * 查询结果集处理
	 *
	 * @param executor
	 * @param mappedStatement
	 * @param queryArgs
	 * @return
	 * @throws SQLException
	 */
	private List<?> queryentityList(Executor executor,
			MappedStatement mappedStatement, final Object[] queryArgs)
			throws SQLException {
		// 定义需要的变量
		final Object parameter = queryArgs[PARAMETER_INDEX];
		final RowBounds rowBounds = (RowBounds) queryArgs[ROW_BOUNDS_INDEX];
		ResultHandler<?> resultHandler = (ResultHandler<?>) queryArgs[RESULT_HANDLER_INDEX];
		Configuration configuration = mappedStatement.getConfiguration();
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);

		// 查询出结果集，并设置到pageVO中
		StatementHandler handler = configuration.newStatementHandler(executor,
				mappedStatement, parameter, rowBounds, resultHandler, boundSql);
		Statement sm = null;
		List<?> entityList = new ArrayList<>();
		try {
			sm = prepareStatement(executor, handler);
			entityList = handler.query(sm, resultHandler);
			return entityList;
		} catch (SQLException ex) {
			log.error(ex);
			throw ex;
		} finally {
			tryCloseStatement(sm);
		}
	}

	/*
	 * private void setTotalResult(BoundSql boundSql, Connection conn,
	 * MetaObject metaObject, Map param) throws SQLException { String countSql =
	 * "select count(*) from ( " + boundSql.getSql() + " ) total";
	 * PreparedStatement prepareStatement = conn.prepareStatement(countSql);
	 * ParameterHandler parameterHandler = (ParameterHandler) metaObject
	 * .getValue("delegate.parameterHandler");
	 * parameterHandler.setParameters(prepareStatement); // 给sql语句设置参数 ResultSet
	 * resultSet = prepareStatement.executeQuery(); if (resultSet.next()) {
	 * PagerVO vo = (PagerVO) param.get("1"); Object total =
	 * resultSet.getObject(1);
	 * vo.setTotalRows(Integer.parseInt(total.toString())); param.put("1", vo);
	 * System.out.println(vo); } if (resultSet != null) { resultSet.close(); }
	 * if (prepareStatement != null) { prepareStatement.close(); } }
	 */
	/**
	 * 检查是否需要拦截,如果需要,将page对象返回,返回方法使用findPageVO
	 * 
	 * @param sqlId
	 * @param parameter
	 * @return
	 */
	private PageVO checkInvocation(String sqlId, Object parameter) {
		// 如果参数为空，则不进行拦截
		if (null == parameter) {
			return null;
		}
		if (null != sqlId && !sqlId.endsWith(COUNT_SQL_FIX)) {
			return getPageVO(parameter);
		}
		return null;
	}

	/**
	 * 检查是否有page参数，并返回对象
	 * 
	 * @param parameter
	 * @return
	 */
	private PageVO getPageVO(Object parameter) {

		if (parameter instanceof Map) {
			Map<Object, Object> parameterMap = (Map) parameter;
			for (Map.Entry<Object, Object> entry : parameterMap.entrySet()) {
				if (entry.getValue() instanceof PageVO) {
					return (PageVO) entry.getValue();
				}
			}
		}
		if (parameter instanceof PageVO) {
			return (PageVO) parameter;
		}
		return null;
	}

	/**
	 * 预处理Statement，并将其返回
	 *
	 * @param executor
	 * @param handler
	 * @return
	 * @throws SQLException
	 */
	private Statement prepareStatement(Executor executor,
			StatementHandler handler) throws SQLException {
		Statement sm = null;
		// 从Executor中获取事务的连接
		Connection connection = ConnectionLogger.newInstance(executor
				.getTransaction().getConnection(), statementLog, 1);

		// 预处理连接对象
		try {
			sm = handler.prepare(connection, 800);
			handler.parameterize(sm);
			return sm;
		} catch (SQLException ex) {
			tryCloseStatement(sm);
			throw ex;
		} catch (Exception e) {
			log.error(e);
			return sm;
		}

	}

	/**
	 * 尝试关闭
	 * 
	 * @param sm
	 */
	private void tryCloseStatement(Statement sm) {
		if (sm != null) {
			try {
				sm.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
}
