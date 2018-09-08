package ru.geekbrains.java3.dz.dz6.GilAnton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestGetNewArraySplit {

    private static J3Lesson6Gil testObj;
    private Integer[] startArr;
    private Integer[] resArr;
    private int keySearch;

    @Parameterized.Parameters
    public static Collection J3LessonTestGil(){
        return Arrays.asList(new Object[][]{{
           new Integer[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0},
           new Integer[]{5,6,7,8,9,0},
           new Integer[]{4}
            },{
                new Integer[]{1,2,3,0,5,6,7,8,9,0,1,2,3,3,5,6,7,4,9,0},
                new Integer[]{9,0},
                new Integer[]{4}
        },{
                new Integer[]{1,2,3,1,5,6,7,8,9,0,1,2,3,1,5,6,7,8,9,0},
                new Integer[]{1,2,3,1,5,6,7,8,9,0},
                new Integer[]{4}
        }});
    }

    public TestGetNewArraySplit(Integer[] startArr, Integer[] resArr, Integer[] keySearch){
        this.startArr = startArr;
        this.resArr = resArr;
        this.keySearch = keySearch[0];
    }

    @BeforeClass
    public static void init(){
        System.out.println("Start test...");
        testObj = new J3Lesson6Gil();
    }

    @AfterClass
    public static void finish(){
        System.out.println("Finish test.");
    }

    @Test
    public  void testGettingNewArr(){
        Assert.assertArrayEquals(resArr, testObj.getArrayNumberAfterSplit(startArr, keySearch));
    }

}
