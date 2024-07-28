package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    private static Connection conn;

    public static Connection getConn() {
        try {
            // Check if the connection is null or closed
            if (conn == null || conn.isClosed()) {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2", "root", "manager");
            }
        } catch (Exception e) {
            // Print stack trace for debugging
            e.printStackTrace();
        }
        return conn;
    }
}
