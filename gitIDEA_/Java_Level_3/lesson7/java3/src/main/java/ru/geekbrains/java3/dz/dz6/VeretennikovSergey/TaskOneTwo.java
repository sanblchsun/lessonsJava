package ru.geekbrains.java3.dz.dz6.VeretennikovSergey;

public class TaskOneTwo {
    public int[] getPartOfArray(int[] arr) throws RuntimeException {
        if (arr.length == 0) throw new RuntimeException("Входной массив - пустой");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                int[] res = new int[arr.length - i - 1];
                System.arraycopy(arr, i + 1, res, 0, res.length);
                return res;
            }
        }
        throw new RuntimeException("Во входном массиве не найден элемент 4");
    }

    public boolean ArrayIsOneOrFour(int[] arr) {
        if (arr.length == 0) return false;
        boolean countOne = false, countFour = false;
        for (int x : arr) {
            if (x == 1) {
                countOne = true;
            } else if (x==4) {
                countFour = true;
            } else return false;
        }
        return countOne&&countFour;
    }
}


