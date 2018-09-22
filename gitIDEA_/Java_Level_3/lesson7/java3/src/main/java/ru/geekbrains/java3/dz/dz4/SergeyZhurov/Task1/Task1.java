package ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task1;

public class Task1 {
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while(currentLetter != 'A') wait();
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    notifyAll();
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public void printB() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while(currentLetter != 'B') wait();
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    notifyAll();
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public void printC() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') wait();
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    notifyAll();
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}
