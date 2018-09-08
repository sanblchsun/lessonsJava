package ru.geekbrains.java3.dz.dz1.MakosovAleksandr.path1.path2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
// Чать 1 домашки
        for (int num:ChangeElementsArrays(2,3,1,2,3,4,5)) {
            System.out.println(num);
        }
        System.out.println("-------------------");

        for (String str:ChangeElementsArrays(2,3,"1","2","3","4","5")) {
            System.out.println(str);
        }
// Чать 2 домашки

        System.out.println("--------------------");
        System.out.println(ArrayToArrayList(10,20,30,40,50));
        System.out.println(ArrayToArrayList("раз","два","три","четыре","пять"));

    }

    public static <T> T[] ChangeElementsArrays(int a,int b,T...array) {
        T temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

    public static <T> ArrayList ArrayToArrayList(T...array) {
        ArrayList list = new ArrayList<>(Arrays.asList(array));
        return list;
    }
}
