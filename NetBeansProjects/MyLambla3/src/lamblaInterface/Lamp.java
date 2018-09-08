package lamblaInterface;

public class Lamp implements Electrisity {
    public void lampOn() {
        System.out.println("Лампа включена");
    }

    @Override
    public void electrisityOn() {
        lampOn();
    }
}
