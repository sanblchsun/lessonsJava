package ru.geekbrains.java3.dz.dz4.belikovadaria;

public class Abc {
    String state;

    synchronized void a(boolean running) {
        if (!running) {
            state = "a";
            notify();
            return;
        }

        System.out.print("A");

        state = "a";

        notify();

        try {
            while(!state.equals("c")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
        }
    }

    synchronized void b(boolean running) {
        if (!running) {
            state = "b";
            notify();
            return;
        }

        System.out.print("B");

        state = "b";

        notify();

        try {
            while(!state.equals("a")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
        }
    }

    synchronized void c(boolean running) {
        if (!running) {
            state = "c";
            notify();
            return;
        }

        System.out.print("C");

        state = "c";

        notifyAll(); // notifyAll обязательно, чтобы не случился deadlock

        try {
            while(!state.equals("b")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание потока");
        }
    }
}
