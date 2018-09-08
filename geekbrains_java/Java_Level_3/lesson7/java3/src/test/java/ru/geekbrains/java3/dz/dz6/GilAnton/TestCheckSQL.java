package ru.geekbrains.java3.dz.dz6.GilAnton;

import org.junit.*;

import java.sql.Connection;

public class TestCheckSQL {

    private static DB testObj;
    private static Connection conn;

    @BeforeClass
    public static void init(){
        System.out.println("Start test...");
        testObj = new DB();
    }

    @AfterClass
    public static void finish(){
        System.out.println("Finish test.");
    }

    @Before
    public void conn(){
        conn = testObj.getConnectionToDB();
    }

    @After
    public void stop(){
        conn = null;
    }

    @Test
    public void testGettingNewArr(){
        Assert.assertEquals(true, testObj.addToDBTest(conn));
    }



}
