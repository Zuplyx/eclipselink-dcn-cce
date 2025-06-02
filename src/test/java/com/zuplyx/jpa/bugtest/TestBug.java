package com.zuplyx.jpa.bugtest;

import com.zuplyx.jpa.bugtest.connection.CustomConnector;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestBug {

    public static void main(String[] args) throws SQLException {
        String url = args[0];
        String user = args[1];
        String pass = args[2];


        Map<String, Object> props = new HashMap<>();
        props.put("eclipselink.jdbc.connector", new CustomConnector(url, user,pass));
        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa-pu", props);
             EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
