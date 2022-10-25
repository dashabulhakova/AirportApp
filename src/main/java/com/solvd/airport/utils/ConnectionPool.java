package com.solvd.airport.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool pool;
    private static List<Connection> connectionPool = new ArrayList<>(5);

    private ConnectionPool() {
        try {
            InputStream input = new FileInputStream("src/main/resources/database.properties");
            Properties p = new Properties();
            p.load(input);
            input.close();
            String url = p.getProperty("url");
            String user = p.getProperty("username");
            String password = p.getProperty("password");
            for (int i = 0; i < 5; i++) {
                connectionPool.add(DriverManager.getConnection(url, user, password));
            }
        } catch (SQLException e) {
            LOGGER.error("Can't load datbase");
        } catch (FileNotFoundException e) {
            LOGGER.error("Can't find a file");;
        } catch (IOException e) {
            LOGGER.error("Can't connect");;
        }
    }
    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("There are no more available connections!");
        }
        return connectionPool.remove(connectionPool.size() - 1);
    }

    public synchronized void returnConnection(Connection connection) {
        connectionPool.add(connection);
    }
}
