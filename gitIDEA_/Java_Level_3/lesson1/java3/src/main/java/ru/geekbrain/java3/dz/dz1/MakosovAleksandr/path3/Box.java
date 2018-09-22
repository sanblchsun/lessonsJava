package ru.geekbrain.java3.dz.dz1.MakosovAleksandr.path3;

import java.util.function.Predicate;

public class Box<T extends Fruit> implements Comparable<Box>, Predicate<Integer> {
    T typeFruit;
    int countFruit;

    public Box(T type) {
        this.typeFruit = type;
    }
    public float getWeight() {
        return countFruit*typeFruit.getWeight();
    }

    public int getCount() {
        return countFruit;
    }

    public void addFruitToBox(int addToCount) {
        countFruit += addToCount;
    }

    public T getTypeFruit() {
        return typeFruit;
    }

    @Override
    public int compareTo(Box box) {
        return (int)(this.getWeight() - box.getWeight());
    }

    @Override
    public boolean test(Integer integer) {
        return this.getWeight()>integer;
    }
}
