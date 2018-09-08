package ru.geekbrains.java3.dz.dz1.MakosovAleksandr.path3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Box> listBox = new ArrayList<>();

    public static void main(String[] args) {
        Apple apple = new Apple("Яблоки антоновка",1.0f);
        Orange orange = new Orange("Апельсины Дагестан", 1.5f);

        listBox.add(new Box(apple));
        listBox.add(new Box(orange));
        listBox.add(new Box(apple));
        listBox.add(new Box(orange));
        listBox.add(new Box(apple));

        for (Box box:listBox) {
            box.addFruitToBox((int)(Math.random()*100));
        }

        printBox();
        System.out.println("---------------перемещение---------------");
        MoveFruitOfBox1ToBox2(listBox.get(0),listBox.get(1),10);
        System.out.println("------------------------------");
        MoveFruitOfBox1ToBox2(listBox.get(0),listBox.get(2),10);
        System.out.println("---------------перемещение---------------");

        printBox();

        Collections.sort(listBox);
        System.out.println("--------------сортировка----------------");
        printBox();

        System.out.println("\n" + "Список ящиков с весом фруктов больше 100");
        listBox.stream().filter((box) -> box.test(100)).
                forEach(box -> System.out.println(
                        box.typeFruit.name + "-" + box.getWeight()));
    }

    public static <T> void MoveFruitOfBox1ToBox2(Box box1,Box box2,int countFruit) {
        if (!box1.typeFruit.name.equals(box2.typeFruit.name)) {
            System.out.println("Ящики с разным содержимым");
            return;
        }
        if (box1.countFruit<countFruit) {
            System.out.println("Нет нужного колличества фруктов");
            return;
        }
        box1.addFruitToBox(- countFruit);
        box2.addFruitToBox(countFruit);
    }

    public  static void printBox() {
        listBox.stream().forEach(box -> System.out.println(
                box.typeFruit.name + "-" + box.getWeight()));
    }
}
