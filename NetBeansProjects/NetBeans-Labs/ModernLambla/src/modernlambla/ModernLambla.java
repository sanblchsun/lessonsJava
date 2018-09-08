package modernlambla;

import java.util.ArrayList;
import java.util.Collections;

public class ModernLambla {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Collections.addAll(list, 4,5,7,-2,4,-55,0,0);
        
        System.out.println(list.stream().filter((x)->x>0).mapToInt(x->x).sum());
        
        System.out.println(list.stream().filter((x)->x<0).mapToInt(x->x).sum());
        
        System.out.println("В списке ноль встречается = " + list.stream().filter((x)->x==0).count() + " раз");
    }
    
}
