package ru.geekbrains.java3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private DBService() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/warehouse",
                    "root",
                    "root"
            );
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during establishing DB connection", throwables);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during connection close", throwables);
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException("SWW during rollback", e);
        }
    }
}
