package ru.geekbrains.java3.dz.dz5.KonstantinS;

public abstract class Stage implements ConsoleColor{
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
