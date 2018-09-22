/**
 Java 3 Lesson 2 Homework
 author Sergey Zhurov
 date 5 Feb 2018
*/
package ru.geekbrains.java3.dz.dz2.ZhurovSergey;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        String currentRead = "";

        System.out.println("Type \"help\" for program syntaxis.");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                try {
                    System.out.print("Enter command: ");
                    currentRead = reader.readLine();
                    String[] split = currentRead.split(" ");
                    if (currentRead.equals("help")) printHelp();
                    else if ((split[0].equals("/цена")) && (split.length == 2))
                        database.printCostByTitle(split[1]);
                    else if (split[0].equals("/сменитьцену") && (split.length == 3))
                        database.changePrice(split[1], Double.parseDouble(split[2]));
                    else if (split[0].equals("/товарыпоцене") && (split.length == 3))
                        database.printGoodsInCostRegion(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
                    else if (!currentRead.equals("exit")) printHelp();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Wrong syntax.");
                    printHelp();
                }
            } while (!currentRead.equals("exit"));
            database.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printHelp() {
        System.out.println("Syntaxis:");
        System.out.println("/цена <наименование товара> для вывода товара и его цены");
        System.out.println("/сменитьцену <наименование товара><новая цена> для смены цены товара");
        System.out.println("/товарыпоцене <мин. цена><макс. цена> для вывода всех товаров из ценового диапазона");
    }
}
