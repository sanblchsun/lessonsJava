/**
 *  Java3 Lesson2 HomeWork by Gil Anton
 */
package ru.geekbrains.java3.dz.dz2;

import java.sql.*;

public class J3Lesson2Gil implements InitOptions {

    public static void main(String[] args) {

        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        DB db = new DB();

        Connection conn = db.getConnectionToDB();

        if( conn != null ){

            try {

                if(args.length != 0) { // Если указаны параметры, тогда используем для выполнения п. 3-5 домашнего задания

                    switch (args[0]){

                        case "/цена":
                            preparedStatement = conn.prepareStatement(queryGetCostofGood);
                            preparedStatement.setString(1, args[1]);
                            resultSet = preparedStatement.executeQuery();
                            resultSet.first();
                            if(resultSet.getRow()==0){
                                System.out.println("That product was not found!");
                            }else{
                                resultSet.beforeFirst();
                                while(resultSet.next()){
                                    System.out.println("Цена за товар " + args[1] + " = " + resultSet.getString(1));
                                }
                            }
                            break;

                        case "/сменитьцену":
                            preparedStatement = conn.prepareStatement(queryUpdateCostofGood);
                            preparedStatement.setString(1, args[2]);
                            preparedStatement.setString(2, args[1]);
                            preparedStatement.executeUpdate();
                            break;

                        case "/товарыпоцене":
                            preparedStatement = conn.prepareStatement(queryGetGoodsInRangeCost);
                            preparedStatement.setString(1, args[1]);
                            preparedStatement.setString(2, args[2]);
                            resultSet = preparedStatement.executeQuery();
                            if(!resultSet.first()){
                                System.out.println("That product was not found!");
                            }else{
                                resultSet.first();
                                while(resultSet.next()){
                                    System.out.println(resultSet.getString(1) + " \t" + resultSet.getString(2));
                                }
                            }
                            break;
                    }
                }
                else{ // Если параметры не переданы, тогда используем для выполнения п.1-2 домашнего задания
                    statement = conn.createStatement();
                    statement.executeUpdate(queryCreateTableGoods);
                    statement.executeUpdate(queryDeleteAllFromTableGoods);
                    preparedStatement = conn.prepareStatement(queryCreateGoods);
                    for(int i = 1; i <= 10000; i++) {
                        preparedStatement.setInt(1, i);
                        preparedStatement.setString(2, "Product" + i);
                        preparedStatement.setFloat(3, i * 10);
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
