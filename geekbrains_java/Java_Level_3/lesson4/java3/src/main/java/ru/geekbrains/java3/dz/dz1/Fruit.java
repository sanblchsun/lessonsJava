package ru.geekbrains.java3.dz.dz1;

/**
 *
 * @author friar
 */
public class Fruit {
    private String fruitName;
    private double weight;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString(){
        return getFruitName()+"("+getWeight()+")";
    }
}
