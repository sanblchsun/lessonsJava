package ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task2;

import java.io.PrintWriter;

public class SyncWriter {
    public static synchronized void write(PrintWriter writer, String output) {
        writer.println(output);
        writer.flush();
    }
}
