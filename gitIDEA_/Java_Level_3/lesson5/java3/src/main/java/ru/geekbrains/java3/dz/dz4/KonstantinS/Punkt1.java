/*
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз, 
порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
*/
package ru.geekbrains.java3.dz.dz4.KonstantinS;

/**
 *
 * @author friar
 */
public class Punkt1 {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int COUNTCHAR=15;
    
    public static void main(String[] args) {
        Punkt1 w = new Punkt1();
        Thread t1 = new Thread(() -> {
            w.printA();
        });
        Thread t2 = new Thread(() -> {
            w.printB();
        });
        Thread t3 = new Thread(() -> {
            w.printC();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNTCHAR; i++) {
                    while (currentLetter != 'A') mon.wait();
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNTCHAR; i++) {
                    while (currentLetter != 'B') mon.wait();
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < COUNTCHAR; i++) {
                    while (currentLetter != 'C') mon.wait();
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
