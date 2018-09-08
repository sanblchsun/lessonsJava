package ru.geekbrains.java3.dz.dz6.VeretennikovSergey;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

/**
 * Created by on 20.02.2018.
 *
 * @author Sergey Veretennikov
 * <p>
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив, метод должен
 * вернуть новый массив, который получен путем вытаскивания элементов из исходного массива, идущих после последней
 * четверки. Входной массив должен содержать хотя бы одну четверку, в противном случае в методе необходимо выбросить
 * RuntimeException.
 * <p>
 * 2. Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 * Написать метод, который проверяет что массив состоит только из чисел 1 и 4. Если в массиве нет хоть одной 4 или 1,
 * то метод вернет false;
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * <p>
 * 3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для проверки того, что при
 * работе с базой корректно добавляются, обновляются и читаются записи. Следует учесть что в базе есть заранее
 * добавленные записи, и после проведения тестов эти записи не должны быть удалены/изменены/добавлены.
 */

public class MainClass {
    private static final Logger logger = Logger.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        try {
            Handler handler = new FileHandler("mylog.log");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Arrays.toString(new TaskOneTwo().getPartOfArray(new int[]{1, 2, 4, 1, 2, 3, 5, 1, 7})));
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.toString(), e);
        }

        //System.out.println(new TaskOneTwo().ArrayIsOneOrFour(new int[]{1, 4, 4, 1, 4, 4, 1}));
    }
}
