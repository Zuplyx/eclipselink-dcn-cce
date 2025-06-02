package com.zuplyx.jpa.bugtest.connection;

import org.eclipse.persistence.sessions.Connector;
import org.eclipse.persistence.sessions.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CustomConnector implements org.eclipse.persistence.sessions.Connector {
    private final String url;
    private final String user;

    public CustomConnector(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    private final String pass;



    @Override
    public Connection connect(Properties properties, Session session) {
        Connection raw = null;
        try {
            raw = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new ConnectionWrapper(raw);
    }

    @Override
    public void toString(java.io.PrintWriter writer) {
        writer.println("CustomConnector using pre-configured connection");
    }

    @Override
    public String getConnectionDetails() {
        return "CustomConnector using pre-configured connection";
    }

    @Override
    public Connector clone() {
        // Return a new connector using the same connection
        return new CustomConnector(url, user, pass);
    }
}

