
package mypaint;

public class Rect extends Shape{
    private int a,b;

    public Rect(int a, int b, int x, int y, boolean shadow) {
        super(x, y, shadow);
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return (double)this.a*this.b;
    }
    
    @Override
    public void print() {
        System.out.print("a= " + a + " b= " + b);
        super.print();
    }
}
