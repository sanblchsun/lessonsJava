package ru.geekbrains.java3.dz.dz1;

/**
 *
 * @author friar
 */
public class Main {

    public static void main(String[] args) {
        testArrays();
        testFruit();
    }
    
    public static void testFruit(){
        Banana[] bananas= {new Banana(),new Banana()};
        Orange[] oranges = {new Orange(),new Orange(),new Orange()};
        Box<Banana> boxBanana = new Box<>(bananas);
        Box<Orange> boxOrange = new Box<>(oranges);
        System.out.println(boxBanana.toString());
        System.out.println(boxOrange.toString());
        System.out.println("boxBanana = "+boxBanana.getWeight());
        System.out.println("boxOranges = "+boxOrange.getWeight());
        System.out.println("(boxBanana = boxOranges) is "+ boxBanana.compare(boxOrange));
        
        System.out.println("---------before--------");
        System.out.println("---------boxBanana--------");
        System.out.println(boxBanana.toString());
        System.out.println("---------boxBanana2--------");
        Box<Banana> boxBanana2 = new Box<>();
        boxBanana.transferFruit(boxBanana2);
        System.out.println("---------after--------");
        System.out.println("---------boxBanana--------");
        System.out.println(boxBanana.toString());
        System.out.println("---------boxBanana2--------");
        System.out.println(boxBanana2.toString());
    }

    public static void testArrays(){
        CustomArray<Double> doubleArray = new CustomArray<>(1.0, 2.0, 3.0, 4.0);
        doubleArray.swapElements(0, 1);
        System.out.println(doubleArray);
        CustomArray<Integer> integerArray = new CustomArray<>(1, 2, 3, 4);
        integerArray.swapElements(2, 3);
        System.out.println(integerArray);
        System.out.println(CustomArray.asList(integerArray.getCustomArray()).toString());
        System.out.println(CustomArray.asList(doubleArray.getCustomArray()).toString());       
    }
}
