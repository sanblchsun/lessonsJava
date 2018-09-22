package ru.geekbrains.java3.dz.dz6.MakosovAleksandr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class MyClassTest1 {
    private MyClass myClass;
    private int[] x;
    private boolean res;

    @Parameterized.Parameters
    public static Collection abracadabra() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{11, 2, 3, 9}, false},
                        {new int[]{1, 44, 3, 2}, true},
                        {new int[]{1, 4, 1, 2}, true},
                        {new int[]{0, 2, 3, 3}, false},
                        {new int[]{1, 2, 4, 3}, true},
                        {new int[]{4, 2, 3, 3}, true},
                }
        );
    }

    public MyClassTest1(int[] x, boolean res) {
        this.x = x;
        this.res = res;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("init myClass");
        myClass = new MyClass();
    }

    @After
    public void tearDown() throws Exception {
        myClass = null;
    }

    @Test
    public void sheckNum() throws Exception {
        Assert.assertEquals(res, myClass.sheckNum(x,4,1));
    }

}