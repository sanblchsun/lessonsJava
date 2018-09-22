package ru.geekbrains.java3.dz.dz4.FilippovAlex;

class MFD {
    private final Object printer = new Object();
    private final Object scanner = new Object();

    void print() {
        synchronized (printer) {
            System.out.println(Thread.currentThread().getName() + ": printed 1, 2, 3 ... pages.");
        }
    }

    void scan() {
        synchronized (scanner) {
            System.out.println(Thread.currentThread().getName() + ": scanned 1, 2, 3 ... pages.");
        }
    }
}
