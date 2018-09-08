package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import java.util.Arrays;

public class Task1 {
    public int[] subArray (int[] arr) {
        int fourPosition = -1;

        if(arr[arr.length - 1] == 4) return null;

        for (int i = arr.length - 2; i >= 0 ; i--)
            if(arr[i] == 4) {
                fourPosition = i;
                break;
            }
        if(fourPosition == -1) throw new RuntimeException("There is no number 4 in the given array.");
        else return Arrays.copyOfRange(arr, fourPosition + 1, arr.length);
    }
}
