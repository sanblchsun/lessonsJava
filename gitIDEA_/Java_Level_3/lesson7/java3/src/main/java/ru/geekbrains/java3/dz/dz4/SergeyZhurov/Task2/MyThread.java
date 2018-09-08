package ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task2;

import java.io.*;

public class MyThread extends Thread {
    private String[] output;
    private PrintWriter writer;

    public MyThread(PrintWriter writer, String[] output) throws FileNotFoundException {
        this.output = output;
        this.writer = writer;
        start();
    }

    public void run() {
        try {
            for(String s : output) {
                SyncWriter.write(writer, s);
                sleep(20);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
