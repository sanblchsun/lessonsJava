package ru.geekbrains.java3.dz.dz2.MakosovAleksandr;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DateBase dateBase = new DateBase();
        try {
            dateBase.getConnectionToDB();
            dateBase.createTable();
            dateBase.clearTable();
            dateBase.addData();
            dateBase.findBase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dateBase.disconnect();
        }
    }

}
