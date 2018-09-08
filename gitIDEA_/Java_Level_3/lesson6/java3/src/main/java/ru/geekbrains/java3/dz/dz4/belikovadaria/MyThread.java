package ru.geekbrains.java3.dz.dz4.belikovadaria;

public class MyThread implements Runnable {
    Thread thrd;
    Abc abcOb;

    MyThread(String n, Abc abc) {
        thrd = new Thread(this, n);
        abcOb = abc;
        thrd.start();
    }

    public void run() {
        if (thrd.getName().compareTo("A") == 0) {
            for(int i=0; i<5; i++) {
                abcOb.a(true);
            }

            abcOb.a(false);
        } else if (thrd.getName().compareTo("B") == 0) {
            for (int i=0; i<5; i++) {
                abcOb.b(true);
            }

            abcOb.b(false);
        } else {
            for (int i=0; i<5; i++) {
                abcOb.c(true);
            }

            abcOb.c(false);
        }
    }
}
