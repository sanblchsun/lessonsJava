package ru.geekbrains.java3.dz.dz4.Karimov_Denis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 implements Runnable {

    public String str = "join to java";
    public File file = new File ("D://test.txt");

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task2());
        Thread t2 = new Thread(new Task2());
        Thread t3 = new Thread(new Task2());

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
         try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
             for (int i = 0; i < 30; i++) {
                 br.write(str);
                 br.newLine();
                 try {
                     System.out.println("Проходы" + i);
                     Thread.sleep(20);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         } catch (IOException e1) {
             e1.printStackTrace();
         }
    }
}
