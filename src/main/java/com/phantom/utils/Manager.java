package com.phantom.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phantom.models.Entity;

public class Manager {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/apptests";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASS = "123";

    private static Manager instance;

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();

            try (
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
                Statement statement = connection.createStatement();
            ) {
                statement.executeQuery("SET NAMES 'utf8'");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return instance;
    }

    private Manager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Entity> list(String table, Mapper<Entity> mapper) {
        String query = "select * from " + table;
        return executeQuery(query, mapper);
    }

    public ArrayList<Entity> oneToManyList(Long testId, String table, Mapper<Entity> mapper) {
        String query = String.format("select * from %s where test_id=%d", table, testId);
        return executeQuery(query, mapper);
    }

    public Entity getById(Long id, String table, Mapper<Entity> mapper) {
        String query = String.format("select * from %s where id = %d", table, id);
        List<Entity> entities = executeQuery(query, mapper);
        if (entities != null && !entities.isEmpty()) {
            return entities.get(0);
        }
        return null;
    }

    public void create(String table, String params, Long count) {
        String query = String.format("insert into %s values (%s)", table, count + params);
        try (
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
            Statement statement = connection.createStatement();
        ) {
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateQuestion(Long testId, String text) {
        String query = String.format("update question set text=%s where test_id=%d", text, testId);
        executeQuery(query, null);
    }

    public void delete(Long id, String table) {
        String query = String.format("delete from %s where id=%d", table, id);
        executeQuery(query, null);
    }

    private <R> ArrayList<R> executeQuery(String query, Mapper<R> mapper) {
        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
                Statement statement = connection.createStatement();
            ) {
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<R> items = new ArrayList<>();
            if (mapper != null) {
                    while (resultSet.next()) {
                    R item = mapper.map(resultSet);
                    items.add(item);
                }
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}