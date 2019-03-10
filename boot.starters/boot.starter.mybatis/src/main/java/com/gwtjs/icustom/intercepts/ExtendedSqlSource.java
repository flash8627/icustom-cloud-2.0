package com.gwtjs.icustom.intercepts;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

public class ExtendedSqlSource implements SqlSource {

	private Configuration configuration;
	private SqlSource sqlSource;

	public ExtendedSqlSource(Configuration configuration, SqlSource sqlSource) {
		this.configuration = configuration;
		this.sqlSource = sqlSource;
	}

	@Override
	public BoundSql getBoundSql(Object parameterObject) {
		BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
		return boundSql;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/*
	 * public Configuration getConfiguration() { return configuration; }
	 */

}
