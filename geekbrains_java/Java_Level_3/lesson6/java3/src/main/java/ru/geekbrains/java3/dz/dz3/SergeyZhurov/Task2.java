package ru.geekbrains.java3.dz.dz3.SergeyZhurov;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

class Task2 {
    void joinFiles(File[] files, File outFile) {
        ArrayList<FileInputStream> al = new ArrayList<>();
        int currentRead;

        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outFile))){
            for (int i = 0; i < files.length; i++) {
                al.add(new FileInputStream(files[i]));
            }
            Enumeration<FileInputStream> enumeration = Collections.enumeration(al);
            SequenceInputStream in = new SequenceInputStream(enumeration);
            while((currentRead = in.read()) != -1) {
                writer.write(currentRead);
            }
        } catch (IOException e) {
            System.out.println("Error while joining files.");
            e.printStackTrace();
        }
    }
}
