package com.nacreav.navarathrikolu.dao.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

class DBConnectionUtil {
	private static DBConnectionUtil connectionUtil;
	private DataSource dataSource;
	
	private DBConnectionUtil() {
		try {
			dataSource = getDataSource();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private DataSource getDataSource() throws NamingException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/navarathrikolu");
		return ds;
	}
	
	public static DBConnectionUtil getInstance() {
		return connectionUtil==null ? new DBConnectionUtil() : connectionUtil;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
}
