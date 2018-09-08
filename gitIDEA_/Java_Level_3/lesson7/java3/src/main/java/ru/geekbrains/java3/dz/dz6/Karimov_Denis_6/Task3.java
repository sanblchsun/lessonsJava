package ru.geekbrains.java3.dz.dz6.Karimov_Denis_6;

import java.sql.*;

public class Task3 {

    public static void main(String[] args) {
        try {
            getConectionToDBandCreateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            addNow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String last_name;
    private int score;

    private String last_name1;
    private int score1;
    private int score2;

    public static String UrL = "jdbc:postgresql://localhost:5432/postgres";
    public static String User = "postgras";
    public static String Pas = "postgras";

    public static String CreateDB = "CREATE TABLE IF NOT EXISTS students("+
            "id SERIAL AUTO_INCREMENT"+
            "last_name VARCHAR(50) NOT NULL,"+
            "score INT NOT NULL, PRIMARY KEY (id))";

    protected static Connection connection;
    protected static Statement statement;
    protected static PreparedStatement preparedStatement;

    public static void getConectionToDBandCreateTable()throws SQLException{
        preparedStatement = null;
        DriverManager.registerDriver(new org.postgresql.Driver());
        connection = DriverManager.getConnection(UrL, User, Pas);
        statement = connection.createStatement();

        statement.executeUpdate(CreateDB);
    }

    public static void addNow()throws SQLException{
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (ERASHOV, 4);");
        preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (Dudkin, 3);");
        preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (Volkov, 2);");
        preparedStatement.addBatch();
        connection.commit();
    }
    public void addStudents(String last_name, int score)throws SQLException{
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (?, ?);");
            preparedStatement.setInt(2, score);
            preparedStatement.setString(1, last_name);

        //preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (?, ?);");
        //preparedStatement = connection.prepareStatement("INSERT INTO students (last_name, score) VALUES (Durasova, 5)");
        preparedStatement.addBatch();
        connection.commit();
    }
    public int updateDB(String last_name1, int score1)throws SQLException{
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("UPDATE students SET score = ? WHERE last_name = ?;");
        preparedStatement.setString(1, last_name);
        preparedStatement.setInt(2, score);
        int result = preparedStatement.executeUpdate();
        connection.commit();
        return result;
    }

    public void reedDB(int score2) throws SQLException{
        preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE score = '"+ score + ";");
    }


}
