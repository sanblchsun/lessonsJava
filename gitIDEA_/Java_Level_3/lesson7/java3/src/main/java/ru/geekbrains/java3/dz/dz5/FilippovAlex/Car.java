package ru.geekbrains.java3.dz.dz5.FilippovAlex;

class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private long time;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public long getTime() {
        return time;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            SpeedRacer.start.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long startTime = System.currentTimeMillis();
        for (Stage stage : race.getStages()) {
            stage.go(this);
        }
        SpeedRacer.end.countDown();
        time = System.currentTimeMillis() - startTime;
    }
}

