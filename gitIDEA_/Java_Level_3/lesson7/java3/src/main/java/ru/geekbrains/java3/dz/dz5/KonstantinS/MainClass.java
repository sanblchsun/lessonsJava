package ru.geekbrains.java3.dz.dz5.KonstantinS;

// Домашнее задание
// Организуем гонки
// Есть набор правил:
// Все участники должны стартовать одновременно, несмотря на то что на подготовку у каждого уходит разное время
// В туннель не может заехать одновременно больше половину участников(условность)
// Попробуйте все это синхронизировать
// Только после того как все завершат гонку нужно выдать объявление об окончании
// Можете корректировать конструктор машин и добавлять объекты классов из пакета util.concurrent

public class MainClass implements ConsoleColor {
    public static final int CARS_COUNT = 14;
   
    public static void main(String[] args) {
        System.out.println(ANSI_CYAN + "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!" + ANSI_RESET);
        Car.initialize(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),i+1);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try{
            Car.getCdl().await();
            System.out.println(ANSI_CYAN + "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!"+ANSI_RESET);
            Car.reInitCdl();
            Car.getCdl().await();
            System.out.println(ANSI_CYAN + "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!"+ANSI_RESET);
        }catch(InterruptedException ex){
            System.out.println(ex.getLocalizedMessage());
            System.out.println(ANSI_RED + "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась все разбились!!!"+ANSI_RESET);
        }
        
    }
}
