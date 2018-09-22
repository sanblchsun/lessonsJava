package ru.geekbrains.java3.dz.dz2.ZhurovSergey;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.sql.*;

public class Database {
    private static Connection conn;
    private static Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    private static final String databaseUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String pass = "postgres";
    private static final String getCost = "SELECT title, cost FROM goods WHERE title = ?";
    private static final String updateCost = "UPDATE goods SET cost = ? WHERE title = ?";
    private static final String getGoodsInCostRegion =
            "SELECT id, prodid, title, cost FROM goods WHERE (cost >= ?) AND (cost <= ?)";


    public Database() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(databaseUrl, login, pass);
            conn.setAutoCommit(false);
            System.out.println("Connection to database established.");
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS goods (" +
                    "  id SERIAL PRIMARY KEY," +
                    "  prodid INT NOT NULL," +
                    "  title VARCHAR(45) NOT NULL," +
                    "  cost NUMERIC NOT NULL)");
            stmt.execute("DELETE FROM goods");
            ps = conn.prepareStatement(
                    "INSERT INTO goods (prodid, title, cost) VALUES (?, ?, ?)");
            ps.clearBatch();
            for (int i = 1; i <= 10000 ; i++) {
                ps.setInt(1, i);
                ps.setString(2, "товар" + i);
                ps.setFloat(3, i * 10);
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
            System.out.println("DB initialized.");
        } catch (SQLException e) {
            System.out.println("Can't initialize DB.");
            e.printStackTrace();
        }
    }

    void printCostByTitle (String title) throws SQLException {
        ps = conn.prepareStatement(getCost);
        ps.setString(1, title);
        rs = ps.executeQuery();
        if (rs.next())
            System.out.println(title + ": " + rs.getDouble("cost"));
        else System.out.println("Такого товара нет.");
    }

     void closeConnection() throws SQLException {
        System.out.println("Terminating program...");
        conn.close();
        ps.close();
    }

    void changePrice (String title, Double newPrice) throws SQLException {
        ps = conn.prepareStatement(updateCost);
        ps.setDouble(1, newPrice);
        ps.setString(2, title);
        ps.execute();
        printCostByTitle(title);
    }

    void printGoodsInCostRegion(Double min, Double max) throws SQLException {
        ps = conn.prepareStatement(getGoodsInCostRegion);
        ps.setDouble(1, min);
        ps.setDouble(2, max);
        rs = ps.executeQuery();
        while (rs.next())
            System.out.println("id: " + rs.getInt(1) + "\tprodid: " + rs.getInt(2) +
            "\tтовар: " + rs.getString(3) + "\tцена: " + rs.getDouble(4));
    }
}
