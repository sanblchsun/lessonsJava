package ru.geekbrains.java3.dz.dz1.VeretennikovSergey;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MassContainer<Integer> integerMassContainer = new MassContainer<>(1, 2, 3, 4, 5, 6);
        integerMassContainer.info();
        // меняем два указанных элемента массива местами
        integerMassContainer.swapMass(1, 5);
        integerMassContainer.info();

        MassContainer<Double> doubleMassContainer = new MassContainer<>(1.0, 2.0, 3.0, 4.0);
        doubleMassContainer.info();
        // меняем два указанных элемента массива местами
        doubleMassContainer.swapMass(3, 5);
        doubleMassContainer.info();
        //преобразуем массив в ArrayList
        ArrayList<Double> list = doubleMassContainer.arrayToArrayList();
        for (Double d : list) System.out.print(" " + d);


    }
}
