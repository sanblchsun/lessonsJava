
package mypaint;

import javafx.scene.transform.Shear;

public class MyPaint {


    public static void main(String[] args) {
        Rect r1 = new Rect(2, 3, -1, -1, true);
        Rect r2 = new Rect(12, 3, 0, 0, true);
        Circle c1 = new Circle(1, 0, 0, true);
        Shape[] d = {r1,r2,c1};
        allArea(d);
        
        //System.out.println(r1.area());
        //r1.move(1, 3).move(3, 5).move(1, -1).print();       
    }

    static void allArea(Shape[] d) {
        for(Shape sh: d) System.out.println(sh.area());
//        for(Shape sh:d) {
//            if(sh instanceof Rect) {
//                Rect r = (Rect)sh;
//                System.out.println(r.area());
//            }else if(sh instanceof Circle) {
//                Circle r = (Circle)sh;
//                System.out.println(r.area());
//                
//            }else System.out.println("Не известный тип данных"  + " " + sh.getClass());
//        }
    }
    
}
