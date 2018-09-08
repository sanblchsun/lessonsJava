package ru.geekbrains.java3.dz.dz6.Karimov_Denis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.geekbrains.java3.dz.dz6.Karimov_Denis_6.Task1_1;

public class Task1_test {

    private static Task1_1 task1_1;

    @BeforeClass
    public static void test1(){
        task1_1 = new Task1_1();
    }

    @Test
    public void test_test1(){
       // int [] tests1 = {12, 15, 2, 17, 89, 58, 4, 72, 74, 10};
       Assert.assertArrayEquals (( new int[]{72, 74, 10}), task1_1.arrToArr(new int[]{12, 15, 2, 17, 89, 58, 4, 72, 74, 10}, 4));
    }
    @Test
    public void test_test2(){
        Assert.assertArrayEquals((new int[]{85,5,10,8}), task1_1.arrToArr(new int[]{12, 14, 4, 136, 74, 7, 85, 5, 10, 8}, 7));
    }
    @Test
    public void test_test3(){
        Assert.assertArrayEquals(task1_1.arrToArr(new int[]{72,14,65,3,81,275,14,122,5,7}, 14), new int[]{122,5,7});
    }
}
