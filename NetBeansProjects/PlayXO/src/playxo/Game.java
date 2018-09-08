package playxo;

import java.util.Arrays;
import java.util.Scanner;

public class Game{
    
    private static int coordinateX;
    private static int coordinateY;   

    public static void gameStep(Figure fig) {       
        while (true) {            
            coordinateX = scannerXY("Введите координату х: ");
            coordinateY = scannerXY("Введите координату у: ");    
            if(Board.boardXO[coordinateY-1][coordinateX-1]==null) {
                Board.boardXO[coordinateY-1][coordinateX-1] = fig;
                break;
            } else {
                    System.out.println("Поле занято");
                }
            }            
        }


    private static int scannerXY(String str) {
        int coordinate;
        System.out.println(str);
        while (true) {  
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()) {
                coordinate = sc.nextInt();
                if(coordinate<4 && coordinate>0) break; else System.out.println("Введите число от 1 до 3");
            }else System.out.println("Вы ввели не верное значение координаты, повторите"); 
        } 
        return coordinate;
    }
}
