package ru.geekbrains.java3.dz.dz5.MakosovAleksandr;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public void runCar(CyclicBarrier cb, CountDownLatch start1) {
        try {
            System.out.println(this.name + " готовится");
            cb.await();
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            start1.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
        if (MainClass.winner) {
            MainClass.winner = false;
            System.out.println("!!! победитель в заезде: " + this.name);
        }
    }
}

