package mylambla;

import java.util.*;
import java.util.function.Predicate;

public class MyLambda {
    public static<T extends Number> double summa(List<T> list,
            Predicate<T> filter) {
        double s = 0;
        for(int i=0;i<list.size();++i)
            if(filter.test(list.get(i)))
                s+=list.get(i).doubleValue();
        return s;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3,4,-6,466,8,99,0);
        
//        for(int el:list) System.out.println(el);
        
        double sum = summa(list, (x)->x<0);
        System.out.println(sum);

    }
    
}
