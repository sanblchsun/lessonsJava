package ru.geekbrains.java3.dz.dz5.KonstantinS;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + ANSI_BLUE + " начал этап: " + description + ANSI_RESET);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + ANSI_GREEN + " закончил этап: " + description + ANSI_RESET);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
