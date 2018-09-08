
package mysort;

import java.lang.reflect.Method;
import java.util.Arrays;

@Developer(fname="Makosov",lname="Aleksandr",data="29.07.2017",vertion="0.1")
class Box implements Comparable {
    int a,b,h;

    public Box(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.a;
        hash = 97 * hash + this.b;
        hash = 97 * hash + this.h;
        return hash;
    }
    
    @Override
    public String toString() {
        return a+" "+b+" "+h;
    }

    @Override
    public int compareTo(Object obj) {
        Box box = (Box)obj;
        int v1 = a*b*h;
        int v2 = box.a*box.b*box.h;
        return v1-v2;
    }

    public void test() {};
    
}

public class MySort {

    public static void main(String[] args) {

        Box[] d = {new Box(1, 4, 20), new Box(4, 7, 2),new Box(1, 1, 2)};
        
        
        Box str = new Box(4,5,5);
        Arrays.sort(d);
        Object obj = d[0];
        Class info =  d.getClass();
        Method[] mt = info.getMethods();
        for(Method m:mt) System.out.println(m.getName());

//        Comparable cmp = (Comparable)obj;
//        System.out.println(cmp.compareTo(d[1]));
       
        for(Box di:d) System.out.println(di);
    }
    
}
