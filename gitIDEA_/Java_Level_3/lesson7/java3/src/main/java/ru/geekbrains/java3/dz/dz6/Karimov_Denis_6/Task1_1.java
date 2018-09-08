package ru.geekbrains.java3.dz.dz6.Karimov_Denis_6;

import ru.geekbrains.java3.lesson6.logging.Example1Base;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task1_1 {

    private static final Logger logger = Logger.getLogger(Task1_1.class.getName());

    public static void main(String[] args) {
        int [] arr = new int[10]/*{12,15,2,17,89,58,4,72,74,10}*/;
        int x = 0;
        Task1_1 task1_1 = new Task1_1();
        task1_1.arrToArr(arr, x);
    }

    public int[] arrToArr(int [] arr, int x){
        int [] arr1 = new int[arr.length];
        int g = 0; int g1 = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x){
                i = g;
                g1= arr[i];
                arr1 = Arrays.copyOfRange(arr, g+1, arr.length);
            }
        }
        if (g1 != x){
            try {
                throw new RuntimeException ("Напутанно");
            }catch (RuntimeException e){
                logger.log(Level.INFO, "Задан некорректный параметр", e);
            }
        }

        return arr1;
        //System.out.println(Arrays.toString(arr1));
    }
}

/*
public static int [] arr = {12,15,2,17,89,58,4,72,74,10};

    public static int[] massToMass(int[]arr) {
        int a = 4;
        int [] arr1 = new int[arr.length];
        int g = 0; int i; int g1 = 0;
        for (i = 0; i < arr.length; i++){
            int lastElem = arr.length - 1;
            if(arr[i] == a) {
                g = i;
                g1=arr[i];
                arr1 = Arrays.copyOfRange(arr, g+1, arr.length);
                //System.arraycopy(arr,0, arr1, g, arr1.length);
            }else if(Не смог сообразить условие для выброса исключения) {
                throw new RuntimeException ("Напутанно");
            }
        }if(g1 != 4) {throw new RuntimeException ("Напутанно");}

                //System.out.println(Arrays.toString(arr1));

                return arr1;
                }
                }
 */
