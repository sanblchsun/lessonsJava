package lamblaInterface;

import java.util.List;
import java.util.ArrayList;

public class Swich {
    private List<Electrisity> ls = new ArrayList<>();
    
    public void swichOn() {
        System.out.println("Выключатель включен");
        for(Electrisity el:ls) if(el!=null) el.electrisityOn();
    }
    
    public void addLS(Electrisity el) {
        ls.add(el);
    }
    
    public void fire() {
        System.out.println("Fire");
    }
}
