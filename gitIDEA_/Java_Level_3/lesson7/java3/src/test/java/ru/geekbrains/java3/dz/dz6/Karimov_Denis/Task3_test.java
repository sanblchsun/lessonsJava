package ru.geekbrains.java3.dz.dz6.Karimov_Denis;

import org.junit.Assert;
import org.junit.BeforeClass;
import ru.geekbrains.java3.dz.dz6.Karimov_Denis_6.Task3;

import java.sql.SQLException;

public class Task3_test {

    private static Task3 task3_test;

    @BeforeClass
    public static void setTask3(){
        task3_test = new Task3();
    }

    public void testAdd(){
        try {
            Assert.assertEquals(task3_test.updateDB("bus",4), 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //А с BD я вообще прилип

}
