package ru.geekbrains.java3.dz.dz4.MakosovAleksandr;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private static DataOutputStream fileData;

    public static void main(String[] args) throws InterruptedException {
        //part 1
        WaitNotifyClass w = new WaitNotifyClass();

        Thread t1 = new Thread(() -> w.printChar('A','B'));
        Thread t2 = new Thread(() -> w.printChar('B','C'));
        Thread t3 = new Thread(() -> w.printChar('C','A'));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println();
        //part 2
        try {
            fileData = new DataOutputStream(new FileOutputStream("1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Thread tr1 = new Thread(() -> w.writeToFIle(fileData,"Пишет поток 1 \n"));
        Thread tr2 = new Thread(() -> w.writeToFIle(fileData,"Пишет поток 2 \n"));
        Thread tr3 = new Thread(() -> w.writeToFIle(fileData,"Пишет поток 3 \n"));
        tr1.start();
        tr2.start();
        tr3.start();
        tr1.join();
        tr2.join();
        tr3.join();
        System.out.println();
        //part 3
        Mfy mfy = new Mfy();
        mfy.scan("документ 1",10);
        mfy.scan("документ 2",18);
        mfy.print("документ 1", 11);
        mfy.print("документ 2", 15);
    }

    private void printChar(char current, char next) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != current) mon.wait();
                    System.out.print(currentLetter);
                    currentLetter = next;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToFIle(DataOutputStream file, String str) {
        try {
            for (int i = 0; i < 10; i++) {
                file.writeUTF(str);
                System.out.print(str);
                Thread.sleep(20);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Mfy {
        private Object monitorPrint=new Object();
        private Object monitorScan=new Object();

        public void print(String doc,int page) {
            new Thread(() -> executeAction(monitorPrint,doc,page,"печать","Отпечатано")).start();
        }

        public void scan(String doc, int page) {
            new Thread(() -> executeAction(monitorScan,doc,page,"сканирование","Отсканировано")).start();
        }

        private void executeAction(Object monitor,String doc, int page,String info,String info1) {
            synchronized (monitor) {
                System.out.println("\n {***********" + "начало " + doc + " " + info + "***********");
                for (int i = 1; i <= page; i++) {
                    System.out.print(i + ",");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\n ***********" + "конец " + doc + " " + info + " " + page + " страниц" + "***********}");
            }
        }
    }
}
