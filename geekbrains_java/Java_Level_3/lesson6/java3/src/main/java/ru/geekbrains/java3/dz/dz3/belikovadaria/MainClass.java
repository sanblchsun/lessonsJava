package ru.geekbrains.java3.dz.dz3.belikovadaria;

import java.io.FileInputStream;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        readMas();
        
    }

    public static void readMas() {
        String fileName = "1.txt";

        try (FileInputStream in = new FileInputStream(fileName)) {
            byte[] arr = new byte[in.available()];
            in.read(arr, 0, in.available());
            for (int i = 0; i < arr.length; i++) {
                System.out.print((char)arr[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }



}
