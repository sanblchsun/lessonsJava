package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task2TrueFalseTest {
    private Task2 check;

    @Before
    public void init() {
        check = new Task2();
    }

    @Test
    public void trueTest() {
        Assert.assertTrue(check.oneAndFour(new int[] {1, 1, 4, 4}));
    }

    @Test
    public void falseTest1() {
        Assert.assertFalse(check.oneAndFour(new int[] {1, 1, 1, 1}));
    }

    @Test
    public void falseTest2() {
        Assert.assertFalse(check.oneAndFour(new int[] {4, 4, 4, 4}));
    }

    @After
    public void tearDown() {
        check = null;
    }
}
