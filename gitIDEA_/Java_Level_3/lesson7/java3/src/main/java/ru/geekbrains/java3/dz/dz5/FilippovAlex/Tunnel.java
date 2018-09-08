package ru.geekbrains.java3.dz.dz5.FilippovAlex;

class Tunnel extends Stage {
    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + getDescription());
                SpeedRacer.tunnel.acquire();
                System.out.println(c.getName() + " начал этап: " + getDescription());
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + getDescription());
                SpeedRacer.tunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
