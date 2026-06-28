package com.framework.database;

import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

	public static ResultSet executeQuery(String query) {

		try {

			Statement statement = DBConnectionManager.getConnection().createStatement();

			return statement.executeQuery(query);

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String getSingleValue(String query, String columnName) {

		try {

			Statement statement = DBConnectionManager.getConnection().createStatement();

			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {

				return rs.getString(columnName);
			}

			return null;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static int getIntValue(String query, String columnName) {

		try {

			ResultSet rs = executeQuery(query);

			if (rs.next()) {

				return rs.getInt(columnName);
			}

			return 0;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}
}