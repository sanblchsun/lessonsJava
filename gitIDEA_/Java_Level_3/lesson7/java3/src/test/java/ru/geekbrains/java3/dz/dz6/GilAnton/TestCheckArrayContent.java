package ru.geekbrains.java3.dz.dz6.GilAnton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(value = Parameterized.class)
public class TestCheckArrayContent {

    private static J3Lesson6Gil testObj;
    private Integer[] checkArr;
    private boolean res;
    HashSet<Integer> checkNum;


    public TestCheckArrayContent(Integer[] checkArr, boolean res){

        checkNum = new HashSet<>();
        checkNum.add(1);
        checkNum.add(4);

        this.checkArr = checkArr;
        this.res = res;

    }

    @Parameterized.Parameters
    public static Collection J3LessonTestGil(){
        return Arrays.asList(new Object[][]{{
                new Integer[]{1,4,4,4,1,1},
                true
        },{
                new Integer[]{1,2,3,0,5,6,7,8,9,0,1,2,3,3,5,6,7,4,9,0},
                false
        },{
                new Integer[]{1,2,3,1,5,6,7,8,9,0,1,2,3,1,5,6,7,8,9,0},
                false
        }});
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
    public  void testCheckContentArr(){
        Assert.assertEquals(res, testObj.checkContentArray(checkArr, checkNum));
    }

}