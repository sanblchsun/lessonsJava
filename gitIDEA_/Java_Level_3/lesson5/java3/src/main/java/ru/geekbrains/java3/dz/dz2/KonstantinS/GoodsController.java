/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.java3.dz.dz2.KonstantinS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 *
 * @author friar
 */
public class GoodsController {

    private static Logger log = Logger.getLogger(GoodsController.class.getName());
    Connection connection = null;

    public GoodsController(Connection connection) {
        this.connection = connection;
    }

    public int[] batchGoods(ArrayList<Goods> goodsList) {

        try (PreparedStatement preStmt = connection.prepareStatement(AppProperties.readProperties("BATCH_GOODS"))) {
            connection.setAutoCommit(false); // Выключаем AutoCommit
            for (Goods g : goodsList) {
                preStmt.setLong(1, g.id);
                preStmt.setObject(2, g.prodid);
                preStmt.setString(3, g.title);
                preStmt.setDouble(4, g.cost);
                preStmt.addBatch();
            }
            int[] result = preStmt.executeBatch();
            connection.commit();
            return result;
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return null;
    }

    public boolean updateGoodsByName(String goodTitle, Double goodCost) {
        try (PreparedStatement preStmt = connection.prepareStatement(AppProperties.readProperties("UPDATE_BY_NAME"))) {
            preStmt.setDouble(1, goodCost);
            preStmt.setString(2, goodTitle);
            return preStmt.execute();
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public boolean deleteGoods() {
        try (Statement stmt = connection.createStatement()) {
            return stmt.execute(AppProperties.readProperties("TRUNCATE_GOODS"));
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public List<Goods> getAllGoods() {
        ArrayList<Goods> goodsArray = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(AppProperties.readProperties("SELECT_ALL"));
            while (rs.next()) {
                goodsArray.add(new Goods(rs.getLong(1), UUID.fromString(rs.getString(2)), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return goodsArray;
    }

    public List<Goods> getGoodsByTitle(String goodTitle) {
        ArrayList<Goods> goodsArray = new ArrayList<>();
        try (PreparedStatement preStmt = connection.prepareStatement(AppProperties.readProperties("SELECT_BY_TITLE"))) {
            preStmt.setString(1, goodTitle);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                goodsArray.add(new Goods(rs.getLong(1), UUID.fromString(rs.getString(2)), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return goodsArray;
    }

    public List<Goods> getGoodsByPrice(Double goodCost, Double biggerGoodCost) {
        ArrayList<Goods> goodsArray = new ArrayList<>();
        try (PreparedStatement preStmt = connection.prepareStatement(AppProperties.readProperties("SELECT_BY_COST"))) {
            preStmt.setDouble(1, goodCost);
            preStmt.setDouble(2, biggerGoodCost);
            ResultSet rs = preStmt.executeQuery();
            while (rs.next()) {
                goodsArray.add(new Goods(rs.getLong(1), UUID.fromString(rs.getString(2)), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return goodsArray;
    }

    public boolean createTableGoods() {
        try (Statement stmt = connection.createStatement()) {
            return stmt.execute(AppProperties.readProperties("CREATE_TABLE_GOODS"));
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }

    public boolean checkTable(String tableName) {
        try (PreparedStatement preStmt = connection.prepareStatement(AppProperties.readProperties("CHECK_TABLE"))) {
            preStmt.setString(1, tableName);
            return preStmt.executeQuery().next();
        } catch (SQLException ex) {
            log.severe(ex.getMessage());
        }
        return false;
    }
}
