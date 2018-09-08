/*
3. Написать класс МФУ, на котором возможны одновременная печать и сканирование документов, 
при этом нельзя одновременно печатать два документа или сканировать 
(при печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", 
при сканировании тоже самое только "отсканировано...", вывод в консоль все также с периодом в 50 мс.)
 */
package ru.geekbrains.java3.dz.dz4.KonstantinS;

/**
 *
 * @author friar
 */
public class Punkt3 {

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final int COUNTCHAR = 15;
    Thread t2;
    Thread t1;
    static Punkt3 w;

    public static void main(String[] args) {
        w = new Punkt3();
        try {
            for (int i = 0; i < 40; i++) {
                w.startScannig();
                w.startPrinting();
                Thread.sleep(300);
            }
        } catch (InterruptedException ex) {

        }
    }

    public void startScannig() {
        if (t2 == null || !t2.isAlive()) {
            t2 = new Thread(() -> {
                w.scanning();
            });
            t2.start();
        } else {
            System.out.println("already scannig");
        }
    }

    public void startPrinting() {
        if (t1 == null || !t1.isAlive()) {
            t1 = new Thread(() -> {
                w.printing();
            });
            t1.start();
        } else {
            System.out.println("already printing");
        }
    }

    public void printing() {
        try {
            for (int i = 0; i < COUNTCHAR; i++) {
                System.out.print("printing " + i + "\n");
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {

        }
    }

    public void scanning() {
        try {
            for (int i = 0; i < COUNTCHAR; i++) {
                System.out.print("scanning " + i + "\n");
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {

        }
    }
}
