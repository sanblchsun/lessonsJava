package ru.geekbrains.java3.dz.dz1;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author friar
 * @param <T>
 */
public class Box<T extends Fruit> {

    private ArrayList<T> box;

    Box() {
        box = new ArrayList<>();
    }

    Box(T[] fruits) {
        box = new ArrayList<>(Box.asList(fruits));
    }

    public double getWeight() {
        return box.get(0).getWeight() * ((double) box.size());
    }

    public <M extends Fruit> boolean compare(Box<M> box) {
        return abs(this.getWeight() / box.getWeight() - 1) < 0.00000000000001f;
    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public void transferFruit(Box<T> newBox) {
        for(int i=0;i<box.size();i++){
            newBox.add(box.get(i));
        }
        box.removeAll(box);
    }

    static <T> List<T> asList(final T[] array) {
        final List<T> l = new ArrayList<>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return (l);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < box.size(); i++) {
            sb.append("i[").append(i).append("]=").append(box.get(i)).append("\n");
        }
        return sb.toString();
    }
}
