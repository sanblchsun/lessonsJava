package ru.geekbrains.java3.dz.dz3.SergeyZhurov;

import java.io.*;
import java.util.Date;

class Task3 implements Constants {
    private File file;

    Task3(File file) {
        this.file = file;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= TASK3_PAGES; i++) {
                builder.append("Page").append(i);
                while(builder.length() < TAKS3_PAGE_SIZE * i)
                    builder.append(".");
            }
            writer.write(builder.toString());
        } catch(IOException e) {
            System.out.println("Error initializing file in task 3.");
            e.printStackTrace();
        }
    }

    private void printCurrentPage(int page) {
        byte[] buffer = new byte[TAKS3_PAGE_SIZE];

        try(RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek((page - 1) * TAKS3_PAGE_SIZE);
            raf.read(buffer);
            System.out.println(new String(buffer));
        } catch(IOException e) {
            System.out.println("Cant print requested page in Task 3.");
            e.printStackTrace();
        }
    }

    void askForPage() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                try {
                    System.out.print("Enter page number or \"exit\" to exit: ");
                    String currentRead = (reader.readLine());
                    if (currentRead.equals("exit")) break;
                    int page = Integer.parseInt(currentRead);
                    if ((page <= 0) || (page > TAKS3_PAGE_SIZE)) throw new NumberFormatException();
                    else {
                        Date start = new Date();
                        printCurrentPage(page);
                        Date end = new Date();
                        System.out.println("Task3 file read time:" + (end.getTime() - start.getTime()) + "ms");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong page number. Try again.");
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
