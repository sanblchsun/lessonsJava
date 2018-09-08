package ru.geekbrains.java3.dz.dz4.FilippovAlex;

class MyThread implements Runnable{
    private final Writer writer;
    private final char letter;
    private final String string;

    MyThread(Writer writer, char letter, String string) {
        this.writer = writer;
        this.letter = letter;
        this.string = string;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                writer.print(letter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            writer.write(string);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
