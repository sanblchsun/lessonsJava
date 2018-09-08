package ru.geekbrains.java3.dz.dz4.belikovadaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String args[]) {
        try {
            Strings s = new Strings("file.txt");

            StrThread t1 = new StrThread("First", s);
            StrThread t2 = new StrThread("Second", s);
            StrThread t3 = new StrThread("Third", s);

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            s.close();
        } catch (IOException e) {
            System.err.print("ошибка файла");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.print("Ошибка потоков");
            e.printStackTrace();
        }
    }
}
