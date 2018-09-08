package ru.geekbrains.java3.dz.dz3.FilippovAlex;

public class HomeWork3 {
    public static void main(String[] args) {
        FileWorking demo = new FileWorking();
        demo.readPrint();
        demo.concat("1.txt", "2.txt", "3.txt", "4.txt", "5.txt");
        demo.readBigFile();
    }
}