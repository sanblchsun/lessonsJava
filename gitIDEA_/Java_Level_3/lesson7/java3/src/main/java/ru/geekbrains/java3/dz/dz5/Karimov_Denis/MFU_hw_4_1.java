package ru.geekbrains.java3.dz.dz5.Karimov_Denis;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MFU_hw_4_1 implements Runnable{
    //CyclicBarrier cbr = new CyclicBarrier(1);
    //CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) {
        Thread u = new Thread(new MFU_hw_4());

        u.start();
    }

    synchronized public void Scan() {
            for (int i = 0; i < 20; i++) {
                System.out.println("Отсканировано" + i + "страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



   synchronized public void Print() {
            for (int i = 0; i < 20; i++) {
                System.out.println("Отпечатано" + i + "страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    public void run() {
        new Thread (() -> Print()).start();
        new Thread (() -> Scan()).start();
    }
}
