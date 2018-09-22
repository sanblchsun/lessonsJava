package ru.geekbrains.java3.dz.dz5.Karimov_Denis;

import ru.geekbrains.java3.dz.dz5.Karimov_Denis.Car;
import ru.geekbrains.java3.dz.dz5.Karimov_Denis.Stage;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    CyclicBarrier cb = new CyclicBarrier(2);
    Semaphore smph = new Semaphore(2);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smph.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
               // cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smph.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
