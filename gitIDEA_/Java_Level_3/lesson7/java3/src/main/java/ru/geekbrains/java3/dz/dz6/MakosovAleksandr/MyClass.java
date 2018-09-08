package ru.geekbrains.java3.dz.dz6.MakosovAleksandr;

import java.sql.*;
import java.util.Arrays;

public class MyClass {
    private static Connection connection;
    private static Statement statement;
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "postgres";

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        // Part 1
        Arrays.stream(myClass.afterFour(1, 4, 56, 67, 7, 8, 9, 4, 565, 67)).forEach(value -> System.out.println(value));
        // Part 2
        System.out.println(sheckNum(new int[]{4, 2, 4, 5, 6, 7, 8, 11}, 4, 1));
        //3
        DateBase1 dateBase = new DateBase1();
        try {
            dateBase.getConnectionToDB();
            dateBase.initTable();
            dateBase.addData();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            dateBase.disconnect();
        }
    }

    public int[] afterFour(int ... i) {
        if (Arrays.stream(i).noneMatch(value -> value==4)) throw new RuntimeException("В массиве нет числа: 4");
        else return Arrays.copyOfRange(i,Arrays.asList(Arrays.stream(i).boxed().toArray( Integer[]::new ))
                .lastIndexOf(4)+1,i.length);
    }

    public static boolean sheckNum(int[] arrs, int value1, int value2) {
        boolean[] res = new boolean[2];
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == value1) {
                res[0] = true;
            }
            if (arrs[i] == value2) {
                res[1] = true;
            }
        }
        return res[0] || res[1];
    }

}
