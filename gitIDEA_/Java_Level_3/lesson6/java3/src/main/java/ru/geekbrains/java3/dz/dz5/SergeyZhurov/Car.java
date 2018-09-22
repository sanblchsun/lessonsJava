package ru.geekbrains.java3.dz.dz5.SergeyZhurov;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean winner = false;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch carsReadyForRaceCD, carsFinishedRaceCD;
    private CyclicBarrier carsStartingRace;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch carsReadyForRaceCD, CyclicBarrier carsStartingRace, CountDownLatch carsFinishedRaceCD) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.carsReadyForRaceCD = carsReadyForRaceCD;
        this.carsStartingRace = carsStartingRace;
        this.carsFinishedRaceCD = carsFinishedRaceCD;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            carsReadyForRaceCD.countDown();
            carsStartingRace.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(!winner) {
            System.out.println(this.name + " WINNER!!!");
            winner = true;
        } else System.out.println(this.name + " FINISHED.");
        carsFinishedRaceCD.countDown();
    }
}
