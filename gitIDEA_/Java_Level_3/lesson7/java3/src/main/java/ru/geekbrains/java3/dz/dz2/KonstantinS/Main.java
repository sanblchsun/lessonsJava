/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.java3.dz.dz2.KonstantinS;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author friar
 */
public class Main {

    private static final String DBCONNECTIONSTRING = "jdbc:sqlite:db.sqlite";
    private static Connection dbConnection = null;

    public static void main(String[] args) {
        loggerInit();
        dbConnection = getConnection(DBCONNECTIONSTRING);
        GoodsController goodsController = new GoodsController(dbConnection);

        if (goodsController.checkTable("goods")) {
            goodsController.deleteGoods();
        } else {
            goodsController.createTableGoods();
        }

        ArrayList<Goods> goodsArray = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            goodsArray.add(new Goods(i, UUID.randomUUID(), "товар" + i, i * 10d));
        }
        goodsController.batchGoods(goodsArray);

        if (args.length > 1 && args[0].equals("/цена")) {
            System.out.println("Цена");
            List<Goods> findedArr = goodsController.getGoodsByTitle(args[1]);
            if (findedArr.size() > 0) {
                System.out.println(findedArr.toString());
            } else {
                System.out.println("Нет товара с таким именем.");
            }
        } else {
            if (args.length > 2 && args[0].equals("/товарыпоцене")) {
                System.out.println("Товары в ценовом диапазоне от "+args[1]+" до "+args[2]);
                System.out.println(goodsController.getGoodsByPrice(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
            }
        }

        closeConnection();
    }

    public static Connection getConnection(String connectioString) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(connectioString, "", "");

        } catch (SQLException ex) {
            Logger.getLogger(GoodsController.class
                    .getName()).severe(ex.getLocalizedMessage());
        }
        return null;
    }

    public static void closeConnection() {
        try {
            dbConnection.close();

        } catch (SQLException ex) {
            Logger.getLogger(GoodsController.class
                    .getName()).severe(ex.getLocalizedMessage());
        }
    }

    private static void loggerInit() {
        if (AppProperties.readProperties("LOGTO").equalsIgnoreCase("file")) {
            try {
                InputStream input = new FileInputStream("resources/log.properties");
                LogManager.getLogManager().readConfiguration(input);
            } catch (IOException ex) {
                System.out.println("Login properties not found" + ex.getMessage());
            }
        }
    }

}
