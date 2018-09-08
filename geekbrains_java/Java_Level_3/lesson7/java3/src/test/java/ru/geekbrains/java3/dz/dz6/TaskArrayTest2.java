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
public class TaskArrayTest2 {
    private TaskArray taskArray;
    private int[] array;
    private boolean checkBoolean;

    @Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1, 4, 1, 4, 4, 1, 4}, true},
                        {new int[]{1, 1, 1, 4, 4, 1, 0}, false},
                        {new int[]{4, 4, 4, 1}, true},
                        //  {new int[]{1, 1, 4, 5, 4, 1},true}//not test
                }
        );
    }

    public TaskArrayTest2(int[] arr, boolean check) {
        this.array = arr;
        this.checkBoolean = check;
    }

    @Before
    public void init() {
        taskArray = new TaskArray();
    }

    @After
    public void tearDown() throws Exception {
        taskArray = null;
    }

    @Test
    public void arrTrueOrFalse() {
        Assert.assertEquals(taskArray.arrTrueOrFalse(array), checkBoolean);
    }
}


