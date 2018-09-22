package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task1NullNoFourTest {
    private Task1 task1;

    @Before
    public void init() {
        task1 = new Task1();
    }

    @Test
    public void lastFourTest() {
        Assert.assertNull(task1.subArray(new int[] {1, 2, 3, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void errorTest() {
        task1.subArray(new int[] {1, 2, 3, 5, 6, 7, 8, 9, 0});
    }
}
