/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив, 
метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива, 
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, 
в противном случае в методе необходимо выбросить RuntimeException.
2. Написать набор тестов для этого метода (варианта 3-4 входных данных)

вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
Написать метод, который проверяет что массив состоит только из чисел 1 и 4. Если в массиве нет хоть одной 4 или 1, то метод вернет false;
Написать набор тестов для этого метода (варианта 3-4 входных данных)
3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для проверки того, что при работе с базой корректно добавляются, обновляются и читаются записи. Следует учесть что в базе есть заранее добавленные записи, и после проведения тестов эти записи не должны быть удалены/изменены/добавлены.

 */
package ru.geekbrains.java3.dz.dz6.KonstantinS;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author friar
 */
public class Main {

    public static void main(String[] args) {
        tailAfterFour(new Integer[]{4, 1, 1});
        System.out.println(checkFor14(new Integer[]{4, 1, 1}));
    }

    public static Integer[] tailAfterFour(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                Integer[] arrRet = new Integer[arr.length - 1 - i];
                for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                    arrRet[k] = arr[j];
                }
                return arrRet;
            }
        }
        throw new RuntimeException("4 not found.");
    }

    public static boolean checkFor14(Integer[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]++));
        }
        Set set = map.keySet();
        if (set.size() == 2) {
            if (map.keySet().contains(4) || map.keySet().contains(1)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
