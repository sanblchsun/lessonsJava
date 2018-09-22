import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] strArray = createArrayString();
        Set<String> set = Arrays.stream(strArray).collect(Collectors.toSet());
        System.out.println(set);
        TreeMap <String,Integer> map = new TreeMap<>();
        for (String str:strArray) {
            if(map.containsKey(str))  map.put(str,map.get(str) + 1);
            else map.put(str,1);
        }
        map.forEach((key,val)-> System.out.println(key + "=" + val));
    }

    private static String[] createArrayString() {
        String[] persons = {"Александр","Егор","Даниил"};
        String[] personsMany = new String[20];
        for (int i=0;i<personsMany.length;i++) {
            personsMany[i] = persons[(int)(Math.random()*10/3-1)];
        }
        return personsMany;
    }
}
