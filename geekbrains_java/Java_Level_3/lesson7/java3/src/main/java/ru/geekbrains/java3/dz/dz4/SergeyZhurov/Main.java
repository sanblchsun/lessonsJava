package ru.geekbrains.java3.dz.dz4.SergeyZhurov;

import ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task1.Task1;
import ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task2.MyThread;
import ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task3.MFD;
import ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task3.MPrinter;

import java.io.*;

public class Main implements IMain {
    public static void main(String[] args) {
        Thread t1, t2, t3;

        Task1 task1 = new Task1();                                                      //Task1
        t1 = new Thread(task1::printA);
        t2 = new Thread(task1::printB);
        t3 = new Thread(task1::printC);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_NAME))){    //Task2
            t1 = new MyThread(writer, OUTPUT1);
            t2 = new MyThread(writer, OUTPUT2);
            t3 = new MyThread(writer, OUTPUT3);
            t1.join();
            t2.join();
            t3.join();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();                                                           //Task3
        MFD mfd = new MFD();
        mfd.print(ITEMS);
        mfd.scan(ITEMS);
        try {
            Thread.sleep(100);
            mfd.print(ITEMS);
            Thread.sleep(2000);
            mfd.scan(ITEMS);
            Thread.sleep(2000);
            mfd.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
