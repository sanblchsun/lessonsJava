package ru.geekbrains.java3.dz.dz3.KonstantinS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

/**
 *
 * @author friar
 */
public class Main {

    final private static int CHARONPAGE = 1800;

    public static void main(String[] args) {
        byteFromFile();
        splitStream();
        pages();
    }

    public static void pages() {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (i != -1) {
            i = sc.nextInt();
            if (i != -1) {
                try (RandomAccessFile raf = new RandomAccessFile("pages.txt", "r")) {
                    System.out.println(raf.length());
                    System.out.println(i * CHARONPAGE);
                    if (raf.length() > i * CHARONPAGE) {
                        byte[] buffer = new byte[CHARONPAGE];
                        raf.seek(i * CHARONPAGE);
                        raf.read(buffer, 0, CHARONPAGE);
                        System.out.println(new String(buffer));
                    } else {
                        System.out.println("page not exists");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void splitStream() {
        ArrayList<FileInputStream> al = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                al.add(new FileInputStream("byteArr" + i + ".txt"));
            }
            Enumeration<FileInputStream> ec = Collections.enumeration(al);
            FileOutputStream fos = new FileOutputStream("10in1.txt");
            while (ec.hasMoreElements()) {
                FileInputStream fin = ec.nextElement();
                byte[] buffer = new byte[fin.available()];
                // считываем буфер
                fin.read(buffer, 0, buffer.length);
                // записываем из буфера в файл
                fos.write(buffer, 0, buffer.length);
                fin.close();
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteFromFile() {
        byte[] buffer = new byte[50];
        try (InputStream in = new BufferedInputStream(new FileInputStream("byteArr.txt"))) {
            int count = in.read(buffer, 0, 50);
            System.out.println("Прочитано" + count + "байт");
            System.out.println(Arrays.toString(buffer));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
