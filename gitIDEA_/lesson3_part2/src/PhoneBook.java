import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    private TreeMap<String,Set<String>> map = new TreeMap<>();

    public void Add(String name,String...phoneList) {
        if(map.containsKey(name)) {
            Set<String> val = map.get(name);
            for(String ph:phoneList) val.add(ph);
        }else {
            Set<String> phone = new TreeSet<>();
            for(String ph:phoneList) phone.add(ph);
            map.put(name,phone);
        }
    }

    public Set<String> get(String name) {
        return map.get(name);
    }
}
