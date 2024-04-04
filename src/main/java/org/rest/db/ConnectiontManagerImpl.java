package org.rest.db;

import org.rest.exception.DataBaseDriverLoadException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectiontManagerImpl implements ConnectionManager{
    private static final String DRIVER_CLASS_KEY = "org.postgresql.Driver";
    private static final String URL_KEY = "jdbc:postgresql://localhost:5432/bankaccounts_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "";
    private Connection connection;
    private static ConnectionManager instance;

    private ConnectiontManagerImpl() {
    }
    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectiontManagerImpl();
            loadDriver(DRIVER_CLASS_KEY);
        }
        return instance;
    }

    private static void loadDriver(String driverClass) {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new DataBaseDriverLoadException("Database driver not loaded.");
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL_KEY, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
