package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import java.sql.*;

public class Task3CreateDatabase {
    private static Connection conn;
    private static Statement stmt;
    PreparedStatement ps;

    private static final String databaseUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String pass = "postgres";

    public static void main(String[] args) {
        new Task3CreateDatabase();
    }

    public Task3CreateDatabase() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(databaseUrl, login, pass);
            conn.setAutoCommit(false);
            System.out.println("Connection to database established.");
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "  id SERIAL PRIMARY KEY," +
                    "  last_name VARCHAR(45) NOT NULL," +
                    "  grade NUMERIC NOT NULL)");
            stmt.execute("DELETE FROM students");
            ps = conn.prepareStatement(
                    "INSERT INTO students (last_name, grade) VALUES (?, ?)");
            ps.clearBatch();
            for (int i = 1; i <= 5 ; i++) {
                ps.setString(1, "Student" + i);
                ps.setInt(2, (int)(Math.random() * 4 + 1));
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
            System.out.println("DB initialized.");
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Can't initialize DB.");
            e.printStackTrace();
        }
    }

    void closeConnection() throws SQLException {
        conn.close();
        ps.close();
        System.out.println("Connection closed.");
    }
}