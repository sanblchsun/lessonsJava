package temp;

import java.util.Scanner;

public class Calculator {
   
    public static void main(String[] args) {
        System.out.println("Введите операцию");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        Scanner scan = new Scanner(System.in);
        double a,b,result;
        int operation = 0;        
        while (true) {  
            if(scan.hasNextInt() && ((operation = scan.nextInt())==1) || 
                    operation==2 || operation==3 || operation==4) break;
            System.out.println("Введите операцию от 1 до 4");
        } 
        System.out.println("Введите первое число");
        while (true) {            
            if(scan.hasNextDouble()) {
                a = scan.nextDouble();        
                break;
            }
            else System.out.println("Введите число");
        }
        System.out.println("Введите второе число");
        while (true) {            
            if(scan.hasNextDouble()) {
                b = scan.nextDouble();        
                break;
            }
            else System.out.println("Введите число");
        }   
        if (operation == 1){
            result = a + b;
        } else if (operation == 2){
            result = a - b;
        } else if (operation == 3){
            result = a * b;
        } else {
            result = a / b;
        }
        System.out.println("Результат - " + result);
        }  
}
