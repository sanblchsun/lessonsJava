package ru.geekbrains.java3.dz.dz3.SergeyZhurov;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main implements Constants {
    private File[] task2InputFiles;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        //Task1     Reading array from "Task1" file in res directory
        new Task1().printByteArray(TASK1_FILE);
        //Task2     Joining "0-9.txt" files into Task2 file in res directory
        task2InputFiles = new File[10];
        for (int i = 0; i < task2InputFiles.length; i++) {
            task2InputFiles[i] =
                    new File("./src/main/java/ru/geekbrains/java3/dz/dz3/SergeyZhurov/res/" + i + ".txt");
        }
        new Task2().joinFiles(task2InputFiles, TASK2_OUTPUT_FILE);
        //Task3     Creating "Task3" file and trying to read pages from it measuring time in process
        Date start = new Date();
        Task3 task3 = new Task3(TASK3_FILE);
        Date end = new Date();
        System.out.println("Task3 file initialization time: " + (end.getTime() - start.getTime()) + "ms");
        task3.askForPage();
    }
}
