package ru.geekbrains.java3.dz.dz2;

public interface InitOptions {

    String PROTOCOL_DB = "mysql";
    String serverDB = "localhost";
     String portDB = "3306";
    String nameDB = "geekshop";
     String userDB = "root";
     String passwordDB = "********";

    String nameTableGoods = "Goods";

     String queryCreateDB = "CREATE DATABASE `" + nameDB  + "`;";
//    public final String queryCreateTableGoodsUse = " USE `" + nameDB + "`;";
     String queryCreateTableGoods = "CREATE TABLE IF NOT EXISTS `" + nameTableGoods
                                                + "` ("
                                                + " `id` INT(10) NOT NULL AUTO_INCREMENT,"
                                                + " `prodid` INT(10) NOT NULL UNIQUE,"
                                                + " `title` VARCHAR (150),"
                                                + " `cost` FLOAT(15,3) UNSIGNED, PRIMARY KEY(`id`)"
                                                + " )";
    String queryDeleteAllFromTableGoods = "DELETE FROM `" + nameTableGoods + "`;";
     String queryCreateGoods = "INSERT INTO `" + nameTableGoods + "`(`prodid`, `title`, `cost`) VALUES(?, ?, ?);";
     String queryGetCostofGood = "SELECT `cost` FROM " + nameTableGoods + " WHERE `title` = ?;";
     String queryUpdateCostofGood = "UPDATE " + nameTableGoods + " SET `cost` = ? WHERE `title` = ?;";
     String queryGetGoodsInRangeCost = "SELECT `title`, `cost` FROM " + nameTableGoods + " WHERE `cost` BETWEEN ? AND ?;";




}
