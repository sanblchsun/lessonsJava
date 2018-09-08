package ru.geekbrains.java3.dz.dz6.VeretennikovSergey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)

public class TaskTwoTest {
    private TaskOneTwo taskTwo;
    private int[] arr;
    private boolean check;

    @Parameters
    public static Collection params() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1, 1, 1, 4}, true},
                        {new int[]{4, 4, 4, 1}, true},
                        {new int[]{4, 4, 4, 4}, false},
                        {new int[]{1, 1, 1, 1}, false},
                        //{new int[]{1, 1, 1, 4}, false}  // fail
                }
        );
    }

    public TaskTwoTest(int[] arr, boolean check) {
        this.arr = arr;
        this.check = check;
    }

    @Before
    public void init() {
        taskTwo = new TaskOneTwo();
    }

    @After
    public void tearDown() throws Exception {
        taskTwo = null;
    }

    @Test
    public void paramAddingTest() {
        Assert.assertEquals(taskTwo.ArrayIsOneOrFour(arr), check);
    }
}
