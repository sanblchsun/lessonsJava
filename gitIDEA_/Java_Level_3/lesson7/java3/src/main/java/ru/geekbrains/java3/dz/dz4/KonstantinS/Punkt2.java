/*
2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
 */
package ru.geekbrains.java3.dz.dz4.KonstantinS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author friar
 */
public class Punkt2 {

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int COUNTCHAR = 15;

    /*synchronized*/ public static void WriteToFile(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("3to1.txt",true))) {
            bw.write(data);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Punkt2 w = new Punkt2();
        Thread t1 = new Thread(() -> {
            w.writeA();
        });
        Thread t2 = new Thread(() -> {
            w.writeB();
        });
        Thread t3 = new Thread(() -> {
            w.writeC();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void writeA() {
        try {
            for (int i = 0; i < COUNTCHAR; i++) {
                WriteToFile("A");
                Thread.sleep(20);
            }
        } catch (InterruptedException ex) {

        }
    }

    public void writeB() {
        try {
            for (int i = 0; i < COUNTCHAR; i++) {
                WriteToFile("B");
                Thread.sleep(20);
            }
        } catch (InterruptedException ex) {

        }
    }

    public void writeC() {
        try {
            for (int i = 0; i < COUNTCHAR; i++) {
                WriteToFile("C");
                Thread.sleep(20);
            }
        } catch (InterruptedException ex) {

        }
    }
}
