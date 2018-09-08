package ru.geekbrains.java3.dz.dz1.VeretennikovSergey;

import java.util.ArrayList;
import java.util.Arrays;

public class MassContainer<T extends Number> {
    private T[] mass;

    public MassContainer(T... mass) {
        this.mass = mass;
    }

    public T[] getMass() {
        return mass;
    }

    public void setMass(T[] mass) {
        this.mass = mass;
    }

    public void info() {
        System.out.println(Arrays.toString(mass));
    }

    //метод, который меняет два элемента массива местами.
    public T[] swapMass(int nom1, int nom2) {
        T item2;
        if (nom1 > mass.length || nom1 < 0 || nom2 > mass.length || nom2 < 0) {
            System.out.println("Ошибка");
        } else {
            for (int i = 0; i < mass.length; i++) {
                if (i == (nom1 - 1)) {
                    item2 = mass[i];
                    mass[i] = mass[nom2 - 1];
                    mass[nom2 - 1] = item2;
                }
            }
        }
        return mass;
    }

    //метод, который преобразует массив в ArrayList.
    public ArrayList<T> arrayToArrayList() {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(mass));
        return list;
    }
}
