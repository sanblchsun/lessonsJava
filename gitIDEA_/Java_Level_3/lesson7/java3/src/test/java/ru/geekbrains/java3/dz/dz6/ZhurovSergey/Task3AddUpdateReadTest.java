package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import org.junit.After;
import org.junit.Test;

import java.sql.*;

public class Task3AddUpdateReadTest {
    private static Connection conn;
    private static Statement stmt;
    PreparedStatement ps;
    ResultSet rs;

    private static String databaseUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String pass = "postgres";
    private static String check1 = "Check1_958473rty76awe";
    private static String check2 = "Check2_958473rty76awe";
    private static String update1 = "Update1_958473rty76awetyu546";
    private static String update2 = "Update2_958473rty76awe234fgh";
    private static String psWrite = "INSERT INTO students (last_name, grade) VALUES (?, ?)";
    private static String psUpdate = "UPDATE students SET last_name = ? WHERE last_name = ?";
    private static String psReadAll = "SELECT * FROM students";
    private static String psRead = "SELECT last_name FROM students WHERE last_name = ?";
    private static String psDelete = "DELETE FROM students WHERE last_name = ?";
    private static String updateWriteErrorMessage = "Records in Database are not what they should be.";
    private static String readErrorMessage = "Database read test failed or there is no data.";

    public Task3AddUpdateReadTest() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(databaseUrl, login, pass);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readTest() {
        try {
            ps = conn.prepareStatement(psReadAll);
            rs = ps.executeQuery();
            if (!rs.next()) throw new AssertionError(readErrorMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeTest() {
        try {
            ps = conn.prepareStatement(psWrite);
            ps.clearBatch();
            ps.setString(1, check1);
            ps.setInt(2, 1);
            ps.addBatch();
            ps.setString(1, check2);
            ps.setInt(2, 2);
            ps.addBatch();
            ps.executeBatch();
            conn.commit();
            if(!checkRecord(check1) || !checkRecord(check2)) throw new AssertionError(updateWriteErrorMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void updateTest() {
        try {
            ps = conn.prepareStatement(psUpdate);
            ps.clearBatch();
            ps.setString(1, update1);
            ps.setString(2, check1);
            ps.addBatch();
            ps.setString(1, update2);
            ps.setString(2, check2);
            ps.addBatch();
            ps.executeBatch();
            conn.commit();
            if(!checkRecord(update1) || !checkRecord(update2)) {
                clearAfterLastTest();
                throw new AssertionError(updateWriteErrorMessage);
            }
            clearAfterLastTest();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkRecord(String s1) {
        try {
            ps = conn.prepareStatement(psRead);
            ps.setString(1, s1);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void clearAfterLastTest() {
        try {
            ps = conn.prepareStatement(psDelete);
            ps.setString(1, check1);
            ps.addBatch();
            ps.setString(1, check2);
            ps.addBatch();
            ps.setString(1, update1);
            ps.addBatch();
            ps.setString(1, update2);
            ps.addBatch();
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void deleteTestLinesAndCloseConnection() {
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
