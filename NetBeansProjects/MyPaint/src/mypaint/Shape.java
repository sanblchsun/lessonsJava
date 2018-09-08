
package mypaint;

public abstract class Shape {
    private int x,y;
    private boolean shadow;

    public Shape(int x, int y, boolean shadow) {
        this.x = x;
        this.y = y;
        this.shadow = shadow;
    }

    //private Shape() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isShadow() {
        return shadow;
    }
    
    public Shape move(int dx, int dy) {
        x+=dx;
        y+=dy;
        
        return this;
    }
    
    public void print() {
            System.out.println(" " + x + " " + y + " " + shadow);
    }
    
    public abstract double area();
}
