package ru.geekbrain.java3.dz.dz4.AntonGil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class  WriterToFile implements Runnable{

    private final static Object lock = new Object();
    private static int countThread;
    private String fileName;
    Thread t;
    BufferedWriter bw = null;

    WriterToFile(String fileName){
        this.fileName = fileName;
        countThread++;
        t = new Thread(this, "Thread #" + countThread);
        System.out.println("Start " + t.getName());
        t.start();
    }

    @Override
    public void run() {

        synchronized(lock){

            try{
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

//            System.out.println(t.getName());

            try {
                bw = new BufferedWriter(new FileWriter(this.fileName, true));
                for (int i = 0; i < 20; i++) {
//                    System.out.println(t.getName() + " java " + i);
                    bw.write(t.getName() + " wrote \"java " + i + "\"");
                    bw.append("\n");
                }
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finish " + t.getName());

    }

}
