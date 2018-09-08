package ru.geekbrains.java3.dz.dz5.KonstantinS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable, ConsoleColor {

    private static int CARS_COUNT;
    private static CountDownLatch cdl;
    private static CyclicBarrier cyclicBarrier;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public static CountDownLatch getCdl() {
        return cdl;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, int carNumber) {
        this.race = race;
        this.speed = speed;
        this.name = ANSI_PURPLE + "Участник #" + carNumber + ANSI_RESET;
    }

    public static void initialize(int carsCount) {
        CARS_COUNT = carsCount;
        if (cdl == null) {
            cdl = new CountDownLatch(CARS_COUNT);
        }
        if (cyclicBarrier == null) {
            cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        }
    }

    public static void reInitCdl() {
        cdl = new CountDownLatch(CARS_COUNT);
    }

    @Override
    public void run() {
        //preparing for race
        try {
            System.out.println(ANSI_YELLOW + this.name + " готовится" + ANSI_RESET);
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(ANSI_GREEN + this.name + " готов" + ANSI_RESET);
            cdl.countDown();
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        //force stages
        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
        cdl.countDown();
    }
}
