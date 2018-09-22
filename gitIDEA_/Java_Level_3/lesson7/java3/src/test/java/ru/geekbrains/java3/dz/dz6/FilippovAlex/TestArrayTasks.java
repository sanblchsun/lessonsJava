package ru.geekbrains.java3.dz.dz6.FilippovAlex;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArrayTasks {

    private ArrayTasks tasks;
    private int[] start;
    private int[] end;
    private boolean oneFour;

    public TestArrayTasks(int[] start, int[] end, boolean oneFour) {
        this.start = start;
        this.end = end;
        this.oneFour = oneFour;
        tasks = new ArrayTasks();
    }

    @Parameterized.Parameters
    public static Collection arrays() {
        int[] a1 = new int[]{1, 4, 1, 4, 1, 1, 1, 4, 4, 1};
        int[] b1 = new int[]{1};
        int[] a2 = new int[]{2, 3, 5, 6, 8, 4, 1, 9, 0, 6};
        int[] b2 = new int[]{1, 9, 0, 6};
        int[] a3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] b3 = new int[]{5, 6, 7, 8, 9, 0};
        return Arrays.asList(new Object[][]{
                {a1, b1, true},
                {a2, b2, false},
                {a3, b3, false}
        });
    }

    @Test
    public void subArrayTest() {
        int[] result = tasks.subArray(start);
        assertArrayEquals(end, result);
    }

    @Test
    public void subArrayTestException() {
        int[] result = tasks.subArray(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 0, 1});
        assertEquals(null,result);
    }

    @Test
    public void oneFour() {
        boolean result = tasks.oneFour(start);
        assertTrue(oneFour == result);
    }
}