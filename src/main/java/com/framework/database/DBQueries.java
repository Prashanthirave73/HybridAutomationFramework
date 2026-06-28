package com.framework.database;

public interface DBQueries {

	String USER_BY_EMAIL =

			"SELECT * FROM users " + "WHERE email='%s'";

	String ORDER_BY_ID =

			"SELECT * FROM orders " + "WHERE order_id='%s'";
}
