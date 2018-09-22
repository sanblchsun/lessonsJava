package ru.geekbrains.java3.dz.dz6.Karimov_Denis_6;

import java.util.Arrays;

// ЧЕРНОВИК!!!

public class Task1 {

    public static void main(String[] args) {
        massToMass(arr);
    }

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
            }/*else if(Не смог сообразить условие для выброса исключения) {
                throw new RuntimeException ("Напутанно");
            }*/
        }if(g1 != 4) {throw new RuntimeException ("Напутанно");}

        //System.out.println(Arrays.toString(arr1));

        return arr1;
    }
}

/*else if(arr[i]!=4){
        throw new RuntimeException ("Напутанно");*/