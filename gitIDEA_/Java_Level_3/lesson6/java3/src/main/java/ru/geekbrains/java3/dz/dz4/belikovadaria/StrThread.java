package ru.geekbrains.java3.dz.dz4.belikovadaria;

public class StrThread extends Thread {
    Strings stringsOb;

    StrThread(String n, Strings strings) {
        super(n);
        stringsOb = strings;
    }

    public void run() {
        for(int i =0; i<10; i++) {
            stringsOb.writing(getName());

            try {
                sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
