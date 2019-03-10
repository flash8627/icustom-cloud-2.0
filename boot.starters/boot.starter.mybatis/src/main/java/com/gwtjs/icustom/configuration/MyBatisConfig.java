package com.gwtjs.icustom.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.gwtjs.icustom.intercepts.PageInterceptor;

/**
 * MyBatis基础配置
 * 
 * @author aGuang
 *
 */
@Configuration
@MapperScan(basePackages={"com.gwtjs.icustom"}/*,markerInterface=SqlMapper.class*/)//value={"com.gwtjs.**.dao"}
@ConditionalOnClass(MyBatisConfig.class)// 当Service这个类在类路径中时，且当前容器中没有这个Bean的情况下，开始自动配置 
public class MyBatisConfig implements TransactionManagementConfigurer {
	
	/*public MyBatisConfig() {
		MyBatisConfig mybatisConfig = new MyBatisConfig();
		return mybatisConfig;
	}*/
	
	@Bean(name = "sqlSessionFactory")  @ConditionalOnMissingBean(SqlSessionFactory.class)
	public SqlSessionFactory sqlSessionFactoryBean() {
		//PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setTypeAliasesPackage("com.gwtjs.**.entity");
		
		PageInterceptor pageInterceptor = new PageInterceptor();

		// 添加分页拦截器插件
		sqlSessionFactory.setPlugins(new Interceptor[] { pageInterceptor });

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			sqlSessionFactory.setMapperLocations(resolver
					.getResources("classpath*:com/gwtjs/**/dao/*Dao.xml"));
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Bean @ConditionalOnMissingBean(DataSource.class)
	@ConfigurationProperties(prefix="spring.mybatis.datasource")
	public DataSource dataSource(){
		return new DriverManagerDataSource();
	}

	@Bean(name = "transactionManager")
	@Override @ConditionalOnMissingBean(PlatformTransactionManager.class)
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
