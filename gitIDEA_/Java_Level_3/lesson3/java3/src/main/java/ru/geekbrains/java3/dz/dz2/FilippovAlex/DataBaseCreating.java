package ru.geekbrains.java3.dz.dz2.FilippovAlex;

import java.sql.*;

public class DataBaseCreating {

    public static void main(String[] args) {
        createDB();
        insertDB();
    }

    private static void createDB() {
        try { // Driver registration
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try ( // Takes sources and create table
            Connection connection = DriverManager.getConnection("jdbc:sqlite:shop.db");
            Statement statement = connection.createStatement()
        ) { // Drop/create table in DB
            statement.executeUpdate(
            "DROP TABLE IF EXISTS products;" +
            "CREATE TABLE products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "prod_id INTEGER NOT NULL," +
                "title CHAR(15) NOT NULL," +
                "cost INTEGER NOT NULL" +
            ");"
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void insertDB() {
        try ( // Sources
              Connection connection = DriverManager.getConnection("jdbc:sqlite:shop.db");
              Statement statement = connection.createStatement();
              PreparedStatement preparedStatement = connection.prepareStatement(
                  "INSERT INTO products (prod_id, title, cost)" +
                  "VALUES (?, ? ,?)"
              )
        ) { // Clean table
            statement.executeUpdate(
                "DELETE FROM products"
            );
            for (int i = 1; i <= 10000; i++) { // Update table (!!!very long 35 min!!!)
                preparedStatement.setString(1, "" + i);
                preparedStatement.setString(2, "товар" + i);
                preparedStatement.setString(3, i * 10 + "");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch(); // Batch use haven't time effect (((.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
