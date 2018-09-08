import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.Add("Петров","2353636");
        phoneBook.Add("Сидоров","2343636","2343635");
        phoneBook.Add("Иванов","2373636","2373635");
        phoneBook.Add("Иванов","2373634","2373633");
        phoneBook.Add("Касаткина","2393635");
        String name = "Иванов";
        Set<String> phoneList = phoneBook.get(name);
        try{
            phoneList.forEach((key)-> System.out.println(key));
        }catch (NullPointerException e) {
            System.out.println("Нет в справочнике: " + name) ;
        }

    }
}
