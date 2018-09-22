package ru.geekbrains.java3.dz.dz4.Karimov_Denis;

public class Task1 {
    private final Object blok = new Object();
    private volatile char letter = 'A';

    public static void main(String[] args) {
        Task1 st = new Task1();
        Thread t1 = new Thread (() -> {st.printA();});
        Thread t2 = new Thread(() -> {st.printB();});
        Thread t3 = new Thread(() -> {st.printC();});

        t1.start();
        t2.start();
        t3.start();

    }

    public void printA(){
        synchronized (blok) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') blok.wait();
                    System.out.print("A");
                    letter = 'B';
                    blok.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (blok){
            try {
                for (int i = 0; i < 5; i++){
                    while (letter != 'B') blok.wait();
                    System.out.print("B");
                    letter = 'C';
                    blok.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (blok){
            try {
                for (int i = 0; i < 5; i++){
                    while (letter != 'C') blok.wait();
                    System.out.print("C");
                    letter = 'A';
                    blok.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
