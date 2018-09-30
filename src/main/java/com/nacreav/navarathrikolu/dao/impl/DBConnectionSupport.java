package com.nacreav.navarathrikolu.dao.impl;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

abstract class DBConnectionSupport {
	private static final ResourceBundle DBQUERY_BUNDLE = ResourceBundle.getBundle("dbQuery");
	private static DataSource dataSource;
	
	static {
		try {
			dataSource = getDataSource();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final DataSource getDataSource() throws NamingException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/navarathrikolu");
		return ds;
	}
	
	protected final JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	protected final NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	protected final String getQuery(String key) {
		return DBQUERY_BUNDLE.getString(key.toString());
	}
	
	protected final String getQuery(String key, Object... args) {
		return MessageFormat.format(getQuery(key), args);
	}
		
}
