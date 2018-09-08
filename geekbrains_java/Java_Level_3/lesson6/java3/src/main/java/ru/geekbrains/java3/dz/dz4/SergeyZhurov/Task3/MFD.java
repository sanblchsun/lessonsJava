package ru.geekbrains.java3.dz.dz4.SergeyZhurov.Task3;

public class MFD {
    private MPrinter printer = new MPrinter();
    private MScanner scanner = new MScanner();

    public void print(String[] items) {
        printer.print(items);
    }

    public void scan(String[] items) {
        scanner.scan(items);
    }

    public void stop() {
        printer.interrupt();
        scanner.interrupt();
    }
}
