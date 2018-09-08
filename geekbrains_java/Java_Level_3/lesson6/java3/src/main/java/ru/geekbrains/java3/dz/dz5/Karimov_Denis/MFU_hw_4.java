package ru.geekbrains.java3.dz.dz5.Karimov_Denis;

import java.util.Scanner;
import java.util.concurrent.*;

// Можно еще запустить два потока с отдельными 'run'.

public class MFU_hw_4 implements Runnable {
    //Semaphore sem = new Semaphore(1);
    CyclicBarrier cbr = new CyclicBarrier(1);

    public static void main(String[] args) {
        Thread t0 = new Thread(new MFU_hw_4());
        Thread t1 = new Thread(new MFU_hw_4());
        Thread t2 = new Thread(new MFU_hw_4());
        Thread t3 = new Thread(new MFU_hw_4());


        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
                /*try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Отсканировано" + i + "страница");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("Отпечатана" + i + "страница");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*try {
                    cbr.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }*/
                //sem.release();
            }
        }
    }

}

        /*ExecutorService serv = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду \n\n"
                + "1 - Scan \n"
                + "2 - Print \n");
        for (int i = 0; i < 10; i++) {
            serv.execute(() -> {
                int comand = scanner.nextInt();
                switch (comand) {
                    case 1:
                        System.out.println("Отсканирована 1 страница");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println("Распечатана 1 страница");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("К сожалению, введена неверная команда");
                }

            });
        }
        serv.shutdown();
    }*/



    /*synchronized public void Scann(){

        for(int i = 0; i < 15; i++){
            System.out.println("Отсканировано" + i + "страница");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void Print(){
        for (int i = 0; i<15; i++){
            System.out.println("Отмечатано" + i + "страница");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/


