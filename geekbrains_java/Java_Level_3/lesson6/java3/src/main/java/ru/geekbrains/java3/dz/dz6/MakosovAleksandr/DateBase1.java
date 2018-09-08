package ru.geekbrains.java3.dz.dz6.MakosovAleksandr;

import java.sql.*;
import java.util.Scanner;

public class DateBase1 {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "postgres";
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS students (" +
            "id SERIAL," +
            "name VARCHAR(128) NOT NULL," +
            "score INT NOT NULL," +
            "cost INT NULL,PRIMARY KEY (id))";

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static Scanner scanner = new Scanner(System.in);

    public void getConnectionToDB()throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;

        DriverManager.registerDriver(new org.postgresql.Driver()); // Class.forName("org.postgresql.Driver()")

        connection = DriverManager.getConnection(dbUrl, user, password);
        if (connection != null) {
            System.out.println("connection to db");
            System.out.println("Подключение к базе данных прошло успешно!\n");
            statement = connection.createStatement();
            }
    }


    public void disconnect() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void initTable() throws SQLException {
        boolean isTable = statement.execute(SQL_CREATE);
        if (!isTable) {
            statement.execute("DELETE FROM students;");
        }
    }
    public void addData() throws SQLException {
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students(name, score) VALUES (?,?);");
        for (int i = 1; i <= 5; i++) {
            ps.setString(1, "сотрудник" + i);
            ps.setInt(2, (i * 2));
            ps.executeUpdate();
        }
        connection.commit();
    }

    public static boolean checkBase(Statement statement, String text) {
        int i = 0;
        try {
            i = statement.executeUpdate(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i != 0;

    }

    public static boolean checkData(Statement statement, String text) {
        boolean isNext = false;
        try {
            ResultSet result = statement.executeQuery(text);
            isNext = result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isNext;
    }

}
