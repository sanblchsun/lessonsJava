package ru.geekbrains.java3.dz.dz4.belikovadaria;

import java.io.FileWriter;
import java.io.IOException;

public class Strings {
    FileWriter fw;

    public Strings(String file) throws IOException {
        fw = new FileWriter(file, true);
    }

    synchronized void writing(String str) {
        try {
            fw.append(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
