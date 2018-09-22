package ru.geekbrains.java3.lesson5;

import java.util.concurrent.CyclicBarrier;


public class BarrierExample {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 10; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Поток " + w + " готовится");
                    Thread.sleep(1000 + (int) (3000 * Math.random()));
                    System.out.println("Поток " + w + " готов");
                    cb.await();
                    System.out.println("Поток " + w + " запустился");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


