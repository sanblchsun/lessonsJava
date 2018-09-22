package ru.geekbrains.java3.dz.dz4.belikovadaria;

public class MainTread {


    public static void main(String args[]) {
            Abc abc = new Abc();
            MyThread mt1 = new MyThread("A", abc);
            MyThread mt2 = new MyThread("B", abc);
            MyThread mt3 = new MyThread("C", abc);

            try {
                mt1.thrd.join();
                mt2.thrd.join();
                mt3.thrd.join();
            } catch (InterruptedException e) {
                System.out.println("Прерывание потока");
            }
    }

}
