package ru.geekbrains.java3.dz.dz4.FilippovAlex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeWork4 {
    public static void main(String[] args) {

        System.out.println("Task 1:");
        try {
            Files.delete(Paths.get("1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer writer = new Writer();
        new MyThread(writer, 'A', "Mother\n");
        new MyThread(writer, 'B', "Father\n");
        new MyThread(writer, 'C', "Child\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nTask 2: look to file 1.txt.\n");

        System.out.println("Task 3:");
        MFD device = new MFD();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started to print.");
                device.print();
            }).start();
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started to scan.");
                device.scan();
            }).start();
        }
    }
}
