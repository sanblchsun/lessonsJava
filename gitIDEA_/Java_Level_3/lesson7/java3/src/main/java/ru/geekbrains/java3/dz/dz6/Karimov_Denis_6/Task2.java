package ru.geekbrains.java3.dz.dz6.Karimov_Denis_6;

import java.util.logging.Logger;

public class Task2 {

   /* public static void main(String[] args) {
        task2(true, new int[]{1,1,4,1,4,4,4,4});
    }

    //private static final Logger logger = Logger.getLogger(Task2.class.getName());

    /*public static void main(String[] args) {
        Task2 task_2 = new Task2();
        task_2.task2(true, )
    }*/

    public static boolean task2(boolean res, int[] array){

        for (int i = 0; i < array.length; i++){
            if(array[i] != 1 || array[i] != 4){
                res = false;
            }else res = true;
        }

        return res;
    }
}
