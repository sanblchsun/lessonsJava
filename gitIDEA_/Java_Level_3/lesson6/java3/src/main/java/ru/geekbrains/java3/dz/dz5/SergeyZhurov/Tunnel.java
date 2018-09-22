package ru.geekbrains.java3.dz.dz5.SergeyZhurov;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore tunnelCapacitySemaphore;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        tunnelCapacitySemaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " >| готовится к этапу(ждет): " + description);
                tunnelCapacitySemaphore.acquire();
                System.out.println(c.getName() + " + начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " - закончил этап: " + description);
                tunnelCapacitySemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
