package ru.geekbrains.java3.dz.dz6.ZhurovSergey;

public class Task2 {
    public boolean oneAndFour(int[] arr) {
        boolean one = false, four = false;
        for (int check : arr) {
            if (check == 1) one = true;
            if (check == 4) four = true;
        }
        return (one && four);
    }
}
