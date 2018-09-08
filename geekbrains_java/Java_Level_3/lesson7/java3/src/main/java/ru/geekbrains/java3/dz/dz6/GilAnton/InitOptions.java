package ru.geekbrains.java3.dz.dz6.GilAnton;

public interface InitOptions {

    public final String PROTOCOL = "mysql";
    public final String SERVER = "localhost";
    public final String PORT = "3306";
    public final String NAME = "geekshop";
    public final String USER = "root";
    public final String PSWD = "1989ultra";

    public final String NAMETABLEGOODS = "Goods";

    public final String QUERYCREATEDB = "CREATE DATABASE `" + NAME  + "`;";
    public final String QUERY_CREATE_TABLE_GOODS = "CREATE TABLE IF NOT EXISTS `" + NAMETABLEGOODS
                                                + "` ("
                                                + " `id` INT(10) NOT NULL AUTO_INCREMENT,"
                                                + " `prodid` INT(10) NOT NULL UNIQUE,"
                                                + " `title` VARCHAR (150),"
                                                + " `cost` FLOAT(15,3) UNSIGNED, PRIMARY KEY(`id`)"
                                                + " )";
    public final String QUERY_DELETE_ALL_FROM_TABLE_GOODS = "DELETE FROM `" + NAMETABLEGOODS + "`;";
    public final String QUERY_CREATE_GOODS = "INSERT INTO `" + NAMETABLEGOODS + "`(`prodid`, `title`, `cost`) VALUES(?, ?, ?);";
    public final String QUERY_GET_COSTOF_GOOD = "SELECT `cost` FROM " + NAMETABLEGOODS + " WHERE `title` = ?;";
    public final String QUERY_UPDATE_COSTOF_GOOD = "UPDATE " + NAMETABLEGOODS + " SET `cost` = ? WHERE `title` = ?;";
    public final String QUERY_GET_GOODS_IN_RANGE_COST = "SELECT `title`, `cost` FROM " + NAMETABLEGOODS + " WHERE `cost` BETWEEN ? AND ?;";




}
