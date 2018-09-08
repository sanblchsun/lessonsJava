package ru.geekbrains.java3.dz.dz3.SergeyZhurov;

import java.io.*;
import java.util.Arrays;

class Task1 {
    void printByteArray(File file) {
        byte[] arr;

        try (FileInputStream in = new FileInputStream(file)) {
            arr = new byte[in.available()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (byte)in.read();
            }
            System.out.println(Arrays.toString(arr));
        } catch(IOException e) {
            System.out.println("Error while reading file in task 1.");
            e.printStackTrace();
        }
    }
}
