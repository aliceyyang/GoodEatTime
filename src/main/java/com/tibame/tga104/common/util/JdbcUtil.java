package com.tibame.tga104.common.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {
	
	private static DataSource dataSource;
	
	public static Connection getConnection() throws SQLException, NamingException {
		if(dataSource == null) {
			dataSource = getDataSource();
		}
		return dataSource.getConnection();
	}
	
	private static DataSource getDataSource() throws NamingException {
		return (DataSource) new InitialContext().lookup("java:comp/env/jdbc/GoodEatTime");
	}

}
