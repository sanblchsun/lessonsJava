package ru.geekbrains.java3.dz.dz5.MakosovAleksandr;

// Домашнее задание
// Организуем гонки
// Есть набор правил:
// Все участники должны стартовать одновременно, несмотря на то что на подготовку у каждого уходит разное время
// В туннель не может заехать одновременно больше половину участников(условность)
// Попробуйте все это синхронизировать
// Только после того как все завершат гонку нужно выдать объявление об окончании
// Можете корректировать конструктор машин и добавлять объекты классов из пакета util.concurrent
import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final Semaphore SEMAPHORE_TUNNEL = new Semaphore(CARS_COUNT / 2,true); //количество машин проезжающих по тунелю

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CountDownLatch coutLimited1 = new CountDownLatch(CARS_COUNT);
        CountDownLatch coutLimited2 = new CountDownLatch(CARS_COUNT);
        CountDownLatch coutLimited3 = new CountDownLatch(CARS_COUNT);

        Race race = new Race(new Road(60,coutLimited2), new Tunnel(), new Road(40,coutLimited3));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            final int w = i;
            new Thread(()->cars[w].runCar(cb,coutLimited1)).start();
        }
        coutLimited1.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!");
        coutLimited3.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!");
    }
}
