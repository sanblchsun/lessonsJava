package ru.geekbrains.java3.dz.dz1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author friar
 * @param <T>
 */
public class CustomArray <T> {
    private T[] customArray;

    /**
     *
     * @param i
     * @param j
     */
    public void swapElements(int i, int j){
        T buf = customArray[i];
        customArray[i]=customArray[j];
        customArray[j]=buf;
    }
    
    public CustomArray(T... array) {
        this.customArray = array;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<customArray.length;i++){
            sb.append("i[").append(i).append("]=").append(customArray[i]).append("\n");
        }
        return sb.toString();
    }

    public T[] getCustomArray() {
        return customArray;
    }

    public void setCustomArray(T[] customArray) {
        this.customArray = customArray;
    }
    
    static <T> List<T> asList(final T[] array) {
        final List<T> l = new ArrayList<>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return (l);
    }
}
