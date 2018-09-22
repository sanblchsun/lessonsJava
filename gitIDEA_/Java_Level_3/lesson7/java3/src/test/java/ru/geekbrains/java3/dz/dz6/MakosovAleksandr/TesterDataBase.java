package ru.geekbrains.java3.dz.dz6.MakosovAleksandr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterDataBase {
    Connection connection;
    DateBase1 dateBase = new DateBase1();

    @Before
    public void connect() {
        try {
            dateBase.getConnectionToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @After
    public void disconnect() {
        try {
            dateBase.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() throws SQLException {
        Assert.assertTrue(dateBase.checkBase("DELETE FROM students;"));
    }
    @Test
    public void testInsert() throws SQLException {
        Assert.assertTrue(dateBase.checkBase("INSERT INTO students(name, score) VALUES('студент1',99);"));
    }
    @Test
    public void testUpdate() throws SQLException {
        Assert.assertTrue(dateBase.checkBase("UPDATE students SET score=80 WHERE name='студент2';"));
    }
    @Test
    public void testSelectTrue() throws SQLException {
        Assert.assertTrue(dateBase.checkData("SELECT * FROM students WHERE score>5;"));
    }
    @Test
    public void testSelectFalse() throws SQLException {
        Assert.assertEquals(false,dateBase.checkData("SELECT * FROM students WHERE score>100;"));
    }
}
