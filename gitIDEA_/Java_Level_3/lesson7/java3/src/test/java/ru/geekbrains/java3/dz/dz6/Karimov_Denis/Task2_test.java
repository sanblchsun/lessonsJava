package ru.geekbrains.java3.dz.dz6.Karimov_Denis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.geekbrains.java3.dz.dz6.Karimov_Denis_6.Task2;

public class Task2_test {
    private static Task2 task_2;

    @BeforeClass
    public static void setTask2(){
        task_2 = new Task2();
    }
    @Test
    public void test2_1(){
        Assert.assertEquals(task_2.task2(true, new int[]{1,1,4,1,4,4,4,4}), true);
    }
    @Test
    public void test2_2(){
        int[] array = {4,4,4,4,2};
        Assert.assertFalse(task_2.task2(true, array ));
    }
    @Test
    public void test2_3(){
        Assert.assertEquals(task_2.task2(false, new int[]{1,4,4,4,1,1,1,4}), true);
    }
}
// По-хорошему, тут надо все через assertTrue(False), но как проинициализировать массив в этом случае ума не приложу.