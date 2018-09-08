package ru.geekbrains.java3.dz.dz6.KonstantinS;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author friar
 */
@RunWith(Parameterized.class)
public class MainTest {
    
    @Parameterized.Parameters
        public static Collection<Object> data(){
            return Arrays.asList(new Integer[][][]{{{1,4,1},{1}},{{4,2,1},{2,1}}});
    }
    
    private Integer[] input;
    private Integer[] output;

    public MainTest(Integer[] input, Integer[] output) {
        this.input = input;
        this.output = output;
    }
    
    /**
     * Test of tailAfterFour method, of class Main.
     */
    @Test
    public void testTailAfterFour() {
        System.out.println("tailAfterFour");
        Main instance = new Main();
        assertArrayEquals(output, instance.tailAfterFour(input));
    }
}
