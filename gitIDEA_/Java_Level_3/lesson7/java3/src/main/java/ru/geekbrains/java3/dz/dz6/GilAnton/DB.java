package ru.geekbrains.java3.dz.dz6.GilAnton;

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
                conn = DriverManager.getConnection( "jdbc:" + PROTOCOL + "://" + SERVER + ":" + PORT + "/" + NAME, USER, PSWD);
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

    public boolean addToDBTest(Connection conn){

        try {
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_CREATE_GOODS);
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "Product" + i);
                preparedStatement.setFloat(3, i * 10);
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

}

