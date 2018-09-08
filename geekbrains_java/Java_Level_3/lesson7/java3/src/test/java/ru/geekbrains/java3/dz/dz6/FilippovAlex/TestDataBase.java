package ru.geekbrains.java3.dz.dz6.FilippovAlex;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestDataBase {

    private String updateScore;
    private String family;
    private String scoreForSelect;
    private String scoreNotFound;
    private static DataBase testBase;

    public TestDataBase(int updateScore, String family, int scoreForSelect, int scoreNotFound) {
        this.updateScore = String.valueOf(updateScore);
        this.family = family;
        this.scoreForSelect = String.valueOf(scoreForSelect);
        this.scoreNotFound = String.valueOf(scoreNotFound);
    }

    @Parameterized.Parameters
    public static Collection arrays() {
        return Arrays.asList(new Object[][]{
                {100, "Smith2", 20, 200},
                {200, "Smith3", 30, 300},
                {300, "Smith4", 40, 400}
        });
    }

    @BeforeClass
    public static void beforeClass() {
        testBase = new DataBase("testSchool.db");
        testBase.createDB();
    }

    @Test
    public void testInsertDB() {
        assertTrue(testBase.insertToDB());
    }

    @Test
    public void testUpdateDB() {
        testBase.insertToDB();
        assertTrue(testBase.updateDB(updateScore));
    }

    @Test
    public void testSelectFromDB() {
        testBase.insertToDB();
        assertEquals(family, testBase.selectFromDB(scoreForSelect));
    }

    @Test
    public void testSelectFromDBNot() {
        testBase.insertToDB();
        assertEquals("Not found", testBase.selectFromDB(scoreNotFound));
    }
}