package ru.geekbrains.java3.dz.dz3.FilippovAlex;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class FileWorking {
    private String dir;
    private String fileNameForRead;
    private String fileNameForWrite;
    private Vector<String> list;
    private String bigFileName;
    private int charAtPage;

    FileWorking() {
        dir = "src/main/java/ru/geekbrains/java3/dz/dz3/FilippovAlex/";
        fileNameForRead = "1.txt";
        fileNameForWrite = "6.txt";
        list = new Vector<>();
        bigFileName = "WarAndPeace.txt";
        charAtPage = 1800;
    }

    void readPrint() {
        System.out.println("I. Read and print file " + fileNameForRead);

        try (FileInputStream inputStream = new FileInputStream(
                dir + fileNameForRead)) {
            byte[] text = new byte[50];
            int i = inputStream.read(text);
            System.out.write(text, 0, i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void concat(@NotNull String... files) {
        for (String file : files) {
            list.add(dir + file);
        }

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(
                new StreamEnumeration(list))) {
            Files.copy(sequenceInputStream, Paths.get(dir, fileNameForWrite), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nII. Concatenation files in file " + fileNameForWrite + " is done.\n");
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }

    void readBigFile() {
        System.out.println("III. Read pages from book \"War and peace\" (7267 pages).\n" +
            "Type the page number (for exit type 0):");
        int position;

        try (Scanner scanner = new Scanner(System.in);
             RandomAccessFile raf = new RandomAccessFile(dir + bigFileName, "r")) {
            while ((position = (scanner.nextInt() - 1) * charAtPage) >= 0){
                long length = raf.length() - position;
                if (length > charAtPage) length = charAtPage;
                if (length > 0) {
                    raf.seek(position);
                    for (int i = 0; i < length; i++) {
                        System.out.print((char) raf.read());
                    }
                    System.out.println();
                } else {
                    System.out.println("Page number is too big. Type another number:");
                }
            }
            System.out.println("End of reading.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}