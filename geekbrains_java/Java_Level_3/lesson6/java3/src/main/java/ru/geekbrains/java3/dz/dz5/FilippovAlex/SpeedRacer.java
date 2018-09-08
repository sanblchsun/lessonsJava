package ru.geekbrains.java3.dz.dz5.FilippovAlex;

// Домашнее задание
// Организуем гонки
// Есть набор правил:
// Все участники должны стартовать одновременно, несмотря на то что на подготовку у каждого уходит разное время
// В туннель не может заехать одновременно больше половины участников(условность)
// Попробуйте все это синхронизировать
// Только после того как все завершат гонку нужно выдать объявление об окончании
// Можете корректировать конструктор машин и добавлять объекты классов из пакета util.concurrent

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SpeedRacer {
    private static final int CARS_COUNT = 4;
    static final CyclicBarrier start = new CyclicBarrier(CARS_COUNT,
            () -> System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!"));
    static final Semaphore tunnel = new Semaphore(CARS_COUNT / 2);
    static final CountDownLatch end = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < CARS_COUNT; i++) cars[i] = new Car(race, 15 + (int) (Math.random() * 10));
        for (Car car : cars) new Thread(car).start();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!\nВремя участников:");
        for (Car car : cars) System.out.println(car.getName() + ": " + car.getTime() + "mc");
    }
}
