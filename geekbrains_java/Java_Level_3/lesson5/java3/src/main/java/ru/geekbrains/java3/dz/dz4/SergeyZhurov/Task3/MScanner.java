package ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MScanner extends Thread {
    private List<String> list = new LinkedList<>();
    private int counter = 0;

    MScanner() {
        start();
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            if(list.size() != 0) {
                list.remove(0);
                counter++;
                System.out.println("отсканировано " + counter + " страницы");
                try {
                    sleep(50);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
        System.out.println("Scanner stopped.");
    }

    void scan(String[] items) {
        list.addAll(Arrays.asList(items));
    }
}