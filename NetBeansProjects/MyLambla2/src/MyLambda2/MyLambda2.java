package MyLambda2;

import java.util.*;
import java.util.function.Predicate;


public class MyLambda2 {

    public static <T extends Number> double summa(List<T> list, Predicate<T> pre) {
        double s =0;
        for(int i=0;i<list.size();++i) {
//                if((double) list.get(i).doubleValue()<0) s+=list.get(i).doubleValue(); 
            if(pre.test(list.get(i))) s+=list.get(i).doubleValue();
        }
        return s;
    }

    
    public static void main(String[] args) {
       ArrayList<Integer> ls = new ArrayList<>();
       Collections.addAll(ls, 3,-4,65,82,1,3,-2);
       
//        System.out.println(summa(ls));
        System.out.println(summa(ls,(x)->x<0));
    }
    
}
