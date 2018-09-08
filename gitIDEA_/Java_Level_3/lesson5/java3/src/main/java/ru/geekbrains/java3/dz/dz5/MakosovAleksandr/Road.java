package ru.geekbrains.java3.dz.dz5.MakosovAleksandr;

import java.util.concurrent.CountDownLatch;

public class Road extends Stage {
    CountDownLatch count;

    public Road(int length, CountDownLatch countDownLatch) {
        count = countDownLatch;
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            count.countDown();
        }
    }
}
