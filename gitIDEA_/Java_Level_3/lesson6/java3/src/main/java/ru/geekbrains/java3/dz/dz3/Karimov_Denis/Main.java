package ru.geekbrains.java3.dz.dz3.Karimov_Denis;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        reedingFileAndOutToByteArray();


    }

    public static void reedingFileAndOutToByteArray() throws IOException {
        String filename = "50b.txt";
        int a;
        //byte[]arr = new byte[10000];
        //StringBuilder testFile = new StringBuilder("");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
        BufferedOutputStream out = new BufferedOutputStream(new ByteArrayOutputStream());
        while ((a = in.read()) != -1){
             out.write(a);
        }
//        byte[] arr = out.toByteArray;
//        System.out.println(Arrays.toString(arr));

    }


}
