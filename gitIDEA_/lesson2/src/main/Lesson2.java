package main;


import java.util.Arrays;

public class Lesson2 {

    private static String[][] str;
    private static int sum;
    public static void main(String[] args) {
        try {
            str = new String[4][4];
            try {
                fillingInArray(str);
                BadArray(str);
                System.out.println("sum = " + sum);
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
            }finally {
                System.out.println(sum);
            }
        }catch (NegativeArraySizeException e) {
            System.out.println("Negative Array SizeException.  input Index = [4][4]");
        }

    }

    private static void fillingInArray(String[][] str) {
        for (int i=0;i<str.length;i++) {
            for (int j=0;j<str[i].length;j++) {
                if (i==1 && j==1) str[i][j] = "str";
                else if (i==2 && j==2) str[i][j] = "@";
                else str[i][j] = "1";
            }
        }
    }

    public static void BadArray(String[][] str) throws MyArraySizeException,MyArrayDataException {
            if(str.length!=4 || str[0].length!=4 || str[1].length!=4 || str[2].length!=4)
            throw new MyArraySizeException("Array Index Out Of Bounds Exception. input Index = [4][4]");
            for (int i=0;i<str.length;i++) {
                for (int j=0;j<str[i].length;j++) {
                    try{
                        sum += Integer.parseInt(str[i][j]);
                    }catch (Exception e) {
                        //1)этот вариант отловит все ошибки Integer.parseInt
                        //System.out.println("Number Format Exception. in to Index = " + i + " " + j);

                        //2)этот вариант отловит только первую ошибку Integer.parseInt
                        throw new MyArrayDataException("Number Format Exception. in to Index = " + i + " " + j);
                    }
                }
            }
    }
}
