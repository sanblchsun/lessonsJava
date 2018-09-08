
package mypaint;

public class Circle extends Shape{
    private final int r;

    public Circle(int r, int x, int y, boolean shadow) {
        super(x, y, shadow);
        this.r = r;
        }

    @Override
    public double area() {
        return Math.PI*r*r;
    }
    
    @Override
    public void print() {
        System.out.print("r= " + r);
        super.print();
    }
}
