package ru.geekbrains.java3.dz.dz6.FilippovAlex;

import java.sql.*;

class DataBase {

    private String url;

    DataBase(String name) {
        this.url = "jdbc:sqlite:" + name;
    }

    void makeDB() {
        createDB();
        insertToDB();
    }

    void createDB() {
        try { // Driver registration
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
           HomeWork6.logger.info(String.valueOf(e));
        }
        try ( // Takes sources and create table
              Connection connection = DriverManager.getConnection(url);
              Statement statement = connection.createStatement()
        ) { // Drop/create table in DB
            statement.executeUpdate(
                    "DROP TABLE IF EXISTS students;" +
                            "CREATE TABLE students (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "family CHAR(15) NOT NULL," +
                            "score INTEGER NOT NULL" +
                            ");"
            );
        } catch (SQLException e) {
           HomeWork6.logger.info(String.valueOf(e));
        }
    }

    boolean insertToDB() {
        try ( // Sources
              Connection connection = DriverManager.getConnection(url);
              Statement statement = connection.createStatement();
              PreparedStatement preparedStatement = connection.prepareStatement(
                      "INSERT INTO students (family, score)" +
                          "VALUES (?, ?)"
              )
        ) { // Clean table
            statement.executeUpdate(
                    "DELETE FROM students"
            );
            for (int i = 1; i <= 10; i++) { // Insert to table
                preparedStatement.setString(1, "Smith" + i);
                preparedStatement.setString(2, i * 10 + "");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            HomeWork6.logger.info(String.valueOf(e));
            return false;
        }
        return true;
    }

    boolean updateDB(String scoreUpdate) {
        try ( // Sources
              Connection connection = DriverManager.getConnection(url);
              Statement statement = connection.createStatement();
        ) { // Clean table
            statement.executeUpdate(
                    "UPDATE students SET score = " + scoreUpdate + " WHERE family = \"Smith1\""
            );
        } catch (SQLException e) {
            HomeWork6.logger.info(String.valueOf(e));
            return false;
        }
        return true;
    }

    String selectFromDB(String scoreForSelect) {
        try ( // Sources
              Connection connection = DriverManager.getConnection(url);
              Statement statement = connection.createStatement();
        ) { // Clean table
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM students WHERE score = " + scoreForSelect
            );
            if (resultSet.next()) return resultSet.getString(2);
        } catch (SQLException e) {
            HomeWork6.logger.info(String.valueOf(e));
        }
        return "Not found";
    }
}
