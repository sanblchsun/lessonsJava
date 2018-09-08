
package mycollection;
import java.util.*;

public class MyCollection {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(6);
        list1.add(11);
        list1.add(4);
        
        System.out.println(list1.get(1));
        System.out.println(list1.toString());
        
        LinkedList<Integer> llist1 = new LinkedList<>();
        llist1.add(6);
        llist1.add(11);
        llist1.add(4);
        System.out.println(llist1.get(1));
        System.out.println(llist1);
        
        List<Integer> llist2 = new LinkedList<>();
        llist2.add(6);
        llist2.add(11);
        llist2.add(4);
        System.out.println(llist2.get(1));
        System.out.println(llist2);
        
        HashMap<String,List> tbl = new HashMap<>();
        tbl.put("one", list1);
        tbl.put("two", llist1);
        if(tbl.containsKey("one")) { 
            System.out.println("yes");
            List ls  = tbl.get("one");
            System.out.println(ls);
        }
        
        System.out.println(System.getProperty("sun.cpu.endian"));
        
        Properties ps = System.getProperties();
        Set keys = ps.keySet();
        for(Object obj:keys) {
            String key = (String)obj;
            String val = ps.getProperty(key);
            System.out.println(key + "" + val);
            
        }

        
    }
    
}
