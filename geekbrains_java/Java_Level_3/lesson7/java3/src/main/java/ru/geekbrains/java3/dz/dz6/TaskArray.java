package ru.geekbrains.java3.dz.dz6; /**
 * Homework
 * Created by 22.02.2018.
 *
 * @author Sergey Chernov
 */

import java.util.Arrays;

public class TaskArray {

//    public static void main(String[] args) {
//
//        System.out.println(Arrays.toString(arrayExc(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));
//        System.out.println(Arrays.toString(new boolean[]{arrTrueOrFalse(new int[]{1, 4, 1, 4, 1, 4, 1, 1})}));
//    }

    public int[] arrayExc(int[] arr) throws RuntimeException {

        int flagIndex = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 4)
                flagIndex = i + 1;
        if (flagIndex == -1) throw new RuntimeException();
        else return Arrays.copyOfRange(arr, flagIndex, arr.length);
    }

    public  boolean arrTrueOrFalse(int[] array) {

        int num = 0;
        for (int i : array) {
            if (i == 1 || i == 4) {
                num++;
            }
            else return false;
        }
        return (num > 0 );
    }

}




