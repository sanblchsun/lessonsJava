package ru.geekbrains.java3.dz.dz5.KonstantinS;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private static Semaphore sema;

    public Tunnel(int countSimultaneously) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";

        if (sema == null) {
            sema = new Semaphore(countSimultaneously/2);
            System.out.println(ANSI_CYAN + "ВАЖНОЕ ОБЪЯВЕНИЕ >>> в тоннель одновременно могут заехать автомобилей - " + countSimultaneously/2 + ANSI_RESET);
        }
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + ANSI_BLACK + " готовится к этапу(ждет): " + description + ANSI_RESET);
            sema.acquire();
            System.out.println(c.getName() + ANSI_BLUE + " начал этап: " + description + ANSI_RESET);
            Thread.sleep(length / c.getSpeed() * 1000);
            sema.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + ANSI_GREEN + " закончил этап: " + description + ANSI_RESET);
        }
        System.out.println(ANSI_RED+"ВАЖНОЕ ОБЪЯВЕНИЕ >>> очередь на семафоре - " + sema.getQueueLength()+ANSI_RESET);
    }
}
