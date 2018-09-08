package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Task1ParamTest {
    private Task1 check;
    private int[] x, result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                new int[][][] {
                        {
                                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                                {5, 6, 7, 8, 9, 0}
                        },
                        {
                                {0, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                                {3, 2, 1}
                        },
                        {
                                {45, 56, 23, 6, 7, 4, 4, 1, 2, 3},
                                {1, 2, 3}
                        }

                }
        );
    }

    @Before
    public void init() {
        check = new Task1();
    }

    public Task1ParamTest(int[] x, int[] result) {
        this.x = x;
        this.result = result;
    }

    @Test
    public void paramSubArrayTest() {
        Assert.assertArrayEquals(result, check.subArray(x));
    }

    @After
    public void tearDown() {
        check = null;
    }
}
