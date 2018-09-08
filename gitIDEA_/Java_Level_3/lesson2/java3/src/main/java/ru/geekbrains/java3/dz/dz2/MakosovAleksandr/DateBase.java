package ru.geekbrains.java3.dz.dz2.MakosovAleksandr;

import java.sql.*;
import java.util.Scanner;

public class DateBase {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "postgres";
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS product (" +
            "id SERIAL," +
            "prodid INT NOT NULL," +
            "title VARCHAR(128) NOT NULL," +
            "cost INT NULL,PRIMARY KEY (id))";

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static Scanner scanner = new Scanner(System.in);

    public void getConnectionToDB()throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;

        DriverManager.registerDriver(new org.postgresql.Driver()); // Class.forName("org.postgresql.Driver()")

        connection = DriverManager.getConnection(dbUrl, user, password);
        if (connection != null) {
            System.out.println("connection to db");
            System.out.println("Подключение к базе данных прошло успешно!\n");
            statement = connection.createStatement();
            }
    }

    public void createTable() throws SQLException {
            statement.executeUpdate(SQL_CREATE);
    }

    public void clearTable() throws SQLException {
        statement.execute("DELETE FROM product"); // Очищаем таблицу
        statement.execute("ALTER SEQUENCE product_id_seq RESTART WITH 1"); //обнуляем счетчик поля id
    }

    public void addData() throws SQLException {
        connection.setAutoCommit(false); // Выключаем AutoCommit
        ps = connection.prepareStatement("INSERT INTO product (prodid, title, cost) VALUES (?, ?, ?);"); // Подготовка запроса
        ps.clearBatch();
        for (int i = 1;i<=10000;++i) {
            ps.setInt(1, i);
            ps.setString(2, "товар" + i);
            ps.setInt(3, i*10);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.commit(); // Подтверждение всех изменений в базе
    }

    public void disconnect() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findBase() throws SQLException {
        System.out.println("Введите комаду:");
        String textScanner = scanner.nextLine();
        String[] arr = textScanner.split(" ");
        String textResult = "";
        try {
            if (textScanner.length() < 1) {
                System.out.println("Вы не ввели команду!\nПопробуйте еще раз.");
                findBase();
            } else if (arr[0].startsWith("/")) {
                switch (arr[0]) {
                    case "/цена": {
                        textResult = "SELECT * FROM product WHERE title='" + arr[1] + "'";
                        selectBase(textResult);
                        break;
                    }
                    case "/сменитьцену": {
                        int cost = Integer.parseInt(arr[2]);
                        updateBase(arr[1], cost);
                        break;
                    }
                    case "/товарыпоцене": {
                        int cost1=Integer.parseInt(arr[1]);
                        int cost2=Integer.parseInt(arr[2]);
                        textResult = "SELECT * FROM product WHERE cost>=" + cost1 + " and cost<=" + cost2;
                        selectBase(textResult);
                        break;
                    }
                    default: {
                        System.out.println("Ошибка в запросе. Нет такой команды: "+textScanner);
                        findBase();
                        break;
                    }
                }
            } else {
                System.out.println("Нет такого запроса");
            }
        } catch (NumberFormatException e) {
            System.out.println("Не верно ввели цену товара!");
            findBase();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка в аргументах!");
            findBase();
        }
    }

    private static void updateBase(String title, int cost) throws SQLException {
        connection.setAutoCommit(false);
        ps = connection.prepareStatement("UPDATE product SET cost=? WHERE title=?;");
        ps.setInt(1, cost);
        ps.setString(2, title);
        ps.executeUpdate();
        connection.commit();
        selectBase("SELECT * FROM product WHERE title='" + title + "'");

    }

    private static void selectBase(String textResult) throws SQLException {
        ResultSet result = statement.executeQuery(textResult + ";");
        boolean isNext = result.next();
        if (!isNext) {
            System.out.println("Такого товара нет в базе!");
            return;
        } else {
            while (isNext) {
                System.out.println(result.getString("title") + " " + result.getInt(4));
                isNext = result.next();
            }
            System.out.println("Запрос выполнен.");
        }
    }
}
