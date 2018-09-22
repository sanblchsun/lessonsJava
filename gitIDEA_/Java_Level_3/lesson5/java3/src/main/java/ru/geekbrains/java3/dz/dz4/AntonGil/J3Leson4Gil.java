package ru.geekbrain.java3.dz.dz4.AntonGil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class J3Leson4Gil implements Runnable{

    private String word;
    private boolean flagPause = false;
    private Thread thread;

    J3Leson4Gil(){}

    J3Leson4Gil(String word){
        this.word = word;
        new Thread(word).start();
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public static void main(String[] args){

        String pathToFile = "file.txt";

        /** 1 ЗАДАНИЕ
         * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз,
         * порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
         */
        ArrayList<J3Leson4Gil> arrABC = new ArrayList<>();
        arrABC.add(new J3Leson4Gil("A"));
        arrABC.add(new J3Leson4Gil("B"));
        arrABC.add(new J3Leson4Gil("C"));

        for (int i = 0; i < 5; i++) {
            for (J3Leson4Gil elThread : arrABC) {
                try{
                    Thread.sleep(1);
                    elThread.setPauseTrue();
                    System.out.print(elThread.getWord());
                    Thread.sleep(1);
                    elThread.setPauseFalse();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("");

        /** 2 ЗАДАНИЕ
         * Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл
         * (штук по 10 записей, с периодом в 20 мс)
         */
        clearFile(pathToFile);
        for (int i = 0; i < 3; i++) {
            new WriterToFile(pathToFile);
        }
    }

    synchronized void setPauseTrue(){
        this.flagPause = true;
    }

    synchronized void setPauseFalse(){
        this.flagPause = false;
        notify();
    }

    @Override
    public void run() {
        try{

            System.out.println(this.word);
            Thread.sleep(100);

            synchronized (this){}

            while(this.flagPause){
                wait();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void clearFile(String path){
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
