package ru.geekbrains.java3.dz.dz5.FilippovAlex;

class Road extends Stage {
    Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + getDescription());
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + getDescription());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
