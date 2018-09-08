package ru.geekbrains.java3.dz.dz6.VeretennikovSergey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)

public class TaskOneTest {
    private TaskOneTwo taskOne;
    private int[] arr;
    private int[] res;

    @Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                        {new int[]{1, 2, 3, 4, 0, 4, 7, 8, 9}, new int[]{7, 8, 9}},
                        {new int[]{4, 1, 2, 3}, new int[]{1, 2, 3}},
                        {new int[]{}, new int[]{1, 2, 3}} //fail
                }
        );
    }

    public TaskOneTest(int[] arr, int[] res) {
        this.arr = arr;
        this.res = res;
    }

    @Before
    public void init() {
        taskOne = new TaskOneTwo();
    }

    @After
    public void tearDown() throws Exception {
        taskOne = null;
    }

    @Test
    public void paramAddingTest() {
        Assert.assertArrayEquals(res, taskOne.getPartOfArray(arr));
    }
}
