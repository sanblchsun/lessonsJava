package lamblaInterface;

public class Main {
        
    public static void main(String[] args) {
        Swich sw = new Swich();
        sw.addLS(new Lamp());
        sw.addLS(new Radio());
        sw.addLS( ()-> System.out.println("Пожар") );
        sw.addLS(sw::fire);
        sw.swichOn();
    }
    
}
