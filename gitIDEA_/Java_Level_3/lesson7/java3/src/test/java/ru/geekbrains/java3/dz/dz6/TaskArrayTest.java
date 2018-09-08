package ru.geekbrains.java3.dz.dz6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskArrayTest {


    @Parameters
    public static Collection parameters() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                        {new int[]{1, 2, 3, 4, 0, 4, 5, 7, 9}, new int[]{5, 7, 9}},
                       // {new int[]{4, 5, 9, 1, 2, 3}, new int[]{1, 2, 3}}, //not test

                }
        );
    }
    private int[] array;
    private int[] arrayCopy;
    private TaskArray taskArray;

    public TaskArrayTest(int[] array, int[] arrayCopy ){

        this.array = array;
        this.arrayCopy = arrayCopy;
    }
    @Before
    public void init() {
        taskArray = new TaskArray();
    }
    @After
    public void tearDown() throws Exception { taskArray = null; }

    @Test
    public void arrayExc()
    { Assert.assertArrayEquals(arrayCopy,taskArray.arrayExc(array)); }
}
