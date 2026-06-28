package com.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager {

	private static Connection connection;

	public static Connection getConnection() {

		try {

			if (connection == null || connection.isClosed()) {

				connection = DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);
			}

		} catch (Exception e) {

			throw new RuntimeException("Database connection failed", e);
		}

		return connection;
	}
}
