package ru.geekbrains.java3.dz.dz1.VeretennikovSergey;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    // Конструкторы класса.
    public Box() {
        this.fruits = new ArrayList<T>();
    }

    public Box(ArrayList<T> fruit) {
        this.fruits = fruit;
    }

    public Box(T fruit) {
        this.fruits = new ArrayList<T>();
        fruits.add(fruit);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    // метод который высчитывает вес коробки.
    public float getWeightBox() {
        if (fruits.size() != 0) return fruits.size() * fruits.get(0).getWeight();
        return 0;
    }
    //метод который позволяет сравнить две коробки.
    public boolean compare(Box<?> otherBox) {
        return getWeightBox() == otherBox.getWeightBox();
    }

    //метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку.
    public void replaceAllFruitsToOtherBox(Box<T> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    //метод добавления фрукта в коробку.
    public void addFruit(T fruit){
        fruits.add(fruit);
    }
}
