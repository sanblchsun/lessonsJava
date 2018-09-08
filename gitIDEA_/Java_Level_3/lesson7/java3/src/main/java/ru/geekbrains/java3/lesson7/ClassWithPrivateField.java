package ru.geekbrains.java3.lesson7;

public class ClassWithPrivateField {
    private int pole;

    public ClassWithPrivateField(int field) {
        this.pole = field;
    }

    public void info() {
        System.out.println("field: " + pole);
    }
}
