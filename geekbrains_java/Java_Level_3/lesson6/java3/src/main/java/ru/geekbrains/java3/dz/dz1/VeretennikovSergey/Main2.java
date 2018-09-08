package ru.geekbrains.java3.dz.dz1.VeretennikovSergey;

/*
    3. Большая задача:
    a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
    b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    c. Для хранения фруктов внутри коробки можете использовать ArrayList;
    d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких
        это единицах);
    e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их
        веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку
        с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
    g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main2 {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        System.out.println("Яблоко весит: " + apple1.getWeight());
        System.out.println("Апельсин весит: " + orange1.getWeight());
        System.out.println();

        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);

        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);
        orangeBox1.addFruit(orange3);

        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeightBox());
        System.out.println("Вес коробки с апельсинами: " + orangeBox1.getWeightBox());
        if (appleBox1.compare(orangeBox1)) System.out.println("Веса коробок совпадают");
        System.out.println("Веса коробок не совпадает");
        System.out.println();

        Box<Apple> appleBox2 = new Box<>(apple1);

        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeightBox());
        System.out.println();

        System.out.println("Переваливаем яблоки из первой коробки во вторую");
        System.out.println();
        appleBox1.replaceAllFruitsToOtherBox(appleBox2);
        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeightBox());
        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeightBox());

    }
}
