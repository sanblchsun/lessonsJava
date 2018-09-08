package ru.geekbrains.java3.dz.dz2.FilippovAlex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DataBaseWorking {
    private static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {

        try { // Driver registration
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try ( // Sources
            Connection connection = DriverManager.getConnection("jdbc:sqlite:shop.db");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Для работы с базой данных введите консольную команду (без кавычкек):\n" +
                "\"/цена <имя товара>\" - для поиска товара по наименованию\n" +
                "\"/сменитьцену <товар> <новая цена>\" - для изменения цены товара\n" +
                "\"/товарыпоцене <минимальная цена> <максимальная цена>\" - для поиска товаров в диапазоне цен\n" +
                "\"/exit\" или \"/выход\" - для завершения работы\n");

            label:
            while (true) { // DB's queries
                ResultSet resultSet;
                String query = bufferedReader.readLine();
                String[] s = query.split(" ");
                switch (s[0]) {
                    case "/цена":
                        preparedStatement = connection.prepareStatement(
                            "SELECT * FROM products WHERE title = ?"
                        );
                        preparedStatement.setString(1, s[1]);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) System.out.println("Цена на " + s[1] + ": " + resultSet.getString(4));
                        break;
                    case "/сменитьцену":
                        preparedStatement = connection.prepareStatement(
                            "UPDATE products SET cost = ? WHERE title = ?"
                        );
                        preparedStatement.setString(1, s[2]);
                        preparedStatement.setString(2, s[1]);
                        int i = preparedStatement.executeUpdate();
                        if (i != 0) System.out.println("Цена на " + s[1] + " изменена");
                        else System.out.println("Такого товара нет");
                        break;
                    case "/товарыпоцене":
                        preparedStatement = connection.prepareStatement(
                            "SELECT * FROM products WHERE cost >= ? AND cost <= ?"
                        );
                        preparedStatement.setString(1, s[1]);
                        preparedStatement.setString(2, s[2]);
                        resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            System.out.println("Товары в заданном диапазоене цен:");
                            do {
                                System.out.println(resultSet.getString(3) + "\t" + resultSet.getString(4));
                            } while (resultSet.next());
                        }
                        break;
                    case "/exit":
                    case "/выход":
                        break label;
                    default:
                        System.out.println("Запрос некорректен");
                        break;
                }
            }
            if (preparedStatement != null) preparedStatement.close();
            System.out.println("Соединение закрыто");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
