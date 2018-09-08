package ru.geekbrains.java3.dz.dz6.KonstantinS;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author friar
 */
@RunWith(Parameterized.class)
public class Test14Method {
    
    @Parameterized.Parameters
        public static Collection<Object> data(){
            Object o[][] = new Object[2][2];
            o[0][0]=new Integer[]{1,2,3};
            o[0][1]=false;
            o[1][0]=new Integer[]{1,4,1};
            o[1][1]=true;
            return Arrays.asList(o);
    }
    
    private Integer[] input;
    private boolean output;

    public Test14Method(Integer[] input, boolean output) {
        this.input = input;
        this.output = output;
    }
    
    /**
     * Test of tailAfterFour method, of class Main.
     */
    @Test
    public void testTailAfterFour() {
        System.out.println("checkFor14");
        Main instance = new Main();
        assertSame(output,instance.checkFor14(input));
    }
}
