package ru.geekbrains.java3.dz.dz2;

import java.sql.*;

public class DB implements InitOptions{

    public Connection getConnectionToDB()  {

        Statement st = null;
        Connection conn = null;

//        try{
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        } catch (SQLException e) {
////            e.printStackTrace();
//            System.out.println("Driver not register!");
//        }

        try  {
            try {
                conn = DriverManager.getConnection( "jdbc:" + PROTOCOL_DB + "://" + serverDB + ":" + portDB + "/" + nameDB, userDB, passwordDB);
            } catch (SQLException e) {
//                e.printStackTrace();
                System.out.println("No connection to DB!");
            }
        }
        finally{
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }

        return conn;

    }
}

