package ru.geekbrains.java3.dz.dz5.FilippovAlex;

abstract class Stage {
    int length;
    String description;

    String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
