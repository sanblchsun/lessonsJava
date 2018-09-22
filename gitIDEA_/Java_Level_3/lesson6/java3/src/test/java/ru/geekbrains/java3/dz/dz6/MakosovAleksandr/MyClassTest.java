package ru.geekbrains.java3.dz.dz6.MakosovAleksandr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class MyClassTest {
    private MyClass myClass;
    private int[] x;
    private int[] res;

    @Parameterized.Parameters
    public static Collection abracadabra() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{1,3,4,5,9},new int[]{5,9}},
                        {new int[]{1,3,7,5,7},new int[0]},
                        {new int[]{1,3,4,5,4,0,9},new int[]{0,9}}
                }
        );
    }

    public MyClassTest(int[] x, int[] res) {
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
    public void afterFour() throws Exception {
        Assert.assertArrayEquals(res, myClass.afterFour(x));
    }

}