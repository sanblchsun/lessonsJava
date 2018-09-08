package ru.geekbrains.java3.dz.dz1.KarimovDenis;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
     mas();
     masAtArrayList();

     Box<Integer> boxApple = new Box<>(5);
     Box<Integer> boxOrange = new Box<>(7);

    }

    public static void mas() {
        int[] massiv = {12, 16, 2, 7, 4};
        int temp1 = massiv[1];
        int temp2 = massiv[2];
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i] == massiv[1]) massiv[1] = temp2;
            if(massiv[i] == massiv[2]) massiv[2] = temp1;
        }
        System.out.println(Arrays.toString(massiv));
    }

    public static void masAtArrayList(){
        Integer[] mas = {2, 3, 7, 9, 35};
        List<Integer> arr = Arrays.asList(mas);
        System.out.println(arr.toString());

    }

}
