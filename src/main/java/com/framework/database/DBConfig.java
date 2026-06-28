package com.framework.database;

import java.util.ResourceBundle;

public class DBConfig {

    private static ResourceBundle rb =
            ResourceBundle.getBundle(
                    "config.db");

    public static final String URL =
            rb.getString("db.url");

    public static final String USERNAME =
            rb.getString("db.username");

    public static final String PASSWORD =
            rb.getString("db.password");
}