package ru.geekbrains.java3.dz.dz6.FilippovAlex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Домашнее задание
 * <p>
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив,
 * метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, в противном случае
 * в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных):
 * вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 * <p>
 * 2. Написать метод, который проверяет что массив состоит только из чисел 1 и 4. Если в массиве нет хоть одной
 * 4 или 1, то метод вернет false.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных).
 * <p>
 * 3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для проверки того,
 * что при работе с базой корректно добавляются, обновляются и читаются записи. Следует учесть что в базе есть
 * заранее добавленные записи, и после проведения тестов эти записи не должны быть удалены/изменены/добавлены.
 */

class ArrayTasks {
    int[] subArray(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int index = list.lastIndexOf(4);
        try {
            if (index == list.size() - 1 || index < 0) throw new RuntimeException(
                    "Исходный массив не содержит цифру 4 или после нее нет элементов."
            );
            list = list.subList(index + 1, list.size());
            int[] subArray = new int[list.size()];
            for (int i = 0; i < subArray.length; i++) subArray[i] = list.get(i);
            return subArray;
        } catch (RuntimeException e){
           HomeWork6.logger.info(String.valueOf(e));
        }
        return null;
    }

    boolean oneFour(int[] array) {
        int count1 = 0;
        int count4 = 0;
        for (int i : array) {
            if (i == 1) count1++;
            else if (i == 4) count4++;
            else return false;
        }
        return (count1 != 0 && count4 != 0 && (count1 + count4) == array.length);
    }
}
