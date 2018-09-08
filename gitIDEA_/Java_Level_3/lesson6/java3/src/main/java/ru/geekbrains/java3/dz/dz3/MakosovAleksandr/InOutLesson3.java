/*      1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться
        следующая конструкция:
        ArrayList<InputStream> al = new ArrayList<>();
        ...
        Enumeration<InputStream> e = Collections.enumeration(al);
        3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
        (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
        выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
        дольше 10 секунд, а чтение – занимать свыше 5 секунд.*/

package ru.geekbrains.java3.dz.dz3.MakosovAleksandr;


import java.io.*;
import java.util.*;

public class InOutLesson3 {
    public static ArrayList<InputStream> files = new ArrayList<>();
    public static final String FILE_NAME = "12345.txt";
    public static InputStream in = null;
    public static OutputStream out = null;
    public static SequenceInputStream seq = null ;

    public static void main(String[] args) throws Exception {
//1 part
        byte[] bw = new byte[50];
        for (int i=0;i<50;++i) {
            bw[i] = 10;
        }
        byte[] br = new byte[50];
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream(FILE_NAME);
            out.write(bw);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int size1 = 50;
        readFile(FILE_NAME,size1);
//2 part
        String file2 = "222.txt";
        addFileToArrayList(FILE_NAME, 5); //добавить в массив 5 файлов
        sequenceFiles(file2);// склеиваем 5 файлов и записываем в file2
        int size2 = 5*50;
        readFile(file2,size2);
//3 part
        String file3 = "333.txt";
        addFileToArrayList(FILE_NAME, 1000);//увеличиваем коллекцию на 1000файлов
        sequenceFiles(file3); //склеиваем 1000 и записываем в file3
        pageReadFile(file3); //вывод постранично
    }

    private static void pageReadFile(String fileName) {
        final int PAGE_SIZE = 1800; //количество символов на странице
        byte[] buff=new byte[PAGE_SIZE];
        Scanner scanner = new Scanner(System.in);

        int page = 0; // выбранная страница
        int pages=0; // всего страниц
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            pages = (int)raf.length() / PAGE_SIZE;
            do {
                System.out.printf("%nвведите номер страницы: 1 - %d%n", pages+1);
                page = scanner.nextInt()-1;
            } while (page < 0 && page < pages);
            raf.seek(page*PAGE_SIZE); //переводим курсор к выбранной странице
            raf.read(buff);// считываем данные выбранной страницы в массив
            System.out.println(Arrays.toString(buff));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String fileName,int size) {
        byte[] br1 = new byte[size];
        try {
            in = new BufferedInputStream(new FileInputStream(fileName));
            int count = in.read(br1);
            System.out.println("Прочитано " + count + " байт");
            System.out.println(Arrays.toString(br1));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sequenceFiles(String file) {
        try {
            Enumeration<InputStream> enumeration = Collections.enumeration(files);
            seq = new SequenceInputStream(enumeration);
            out = new FileOutputStream(file);
            int rb = seq.read();
            while (rb != -1) {
                out.write(rb);
                rb = seq.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                seq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeOutputStream(out, file);
                closeInputStream(in, file);
            }
        }
    }

    public static void closeOutputStream(OutputStream out, String fileName) {
        try {
            if (out != null) out.close();
            else System.out.println("Ошибка! Поток OutputStream null! " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при закрытии потока OutputStream! " + fileName + " " + e.getMessage());
            //e.printStackTrace();
        }
    }

    public static void addFileToArrayList(String file, int count) {
        try {
            files.clear();
            for (int i = 1; i <= count; i++) {
                files.add(new FileInputStream(file));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден! " + file + " " + e.getMessage());
        }
    }


    private static void closeInputStream(InputStream in, String fileName) {
        try {
            if (in != null) in.close();
            else System.out.println("Ошибка! Поток inputStream null! " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при закрытии потока inputStream! " + fileName + " " + e.getMessage());
        }
    }
}
