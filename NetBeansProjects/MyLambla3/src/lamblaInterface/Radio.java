package lamblaInterface;

public class Radio implements Electrisity{
    public void radioOn() {
        System.out.println("Радио включено");
    }

    @Override
    public void electrisityOn() {
        radioOn();
    }
    
    
}
