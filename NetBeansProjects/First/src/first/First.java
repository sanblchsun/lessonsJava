
package first;

import java.util.Arrays;
import java.util.Scanner;


public class First {
    
    public static void main(String[] args) {

        int isDay = 0;
        
        String isMonth = null;
        
        int highYear =0;
        
        First f = new First();   
        int year = f.inter("Введите значение ГОД", "Введите целое число из диапозона 1-3000", 1,3000);
        
        boolean isLeapYear = (year%4==0)&& (year%100!=0 || year%400==0);
        
        if (isLeapYear) highYear =1;
        
        int dayNum = f.inter("Введите значение ДЕНЬ ГОДА", "Введите целое число из диапозона 1-365", 1,365 + highYear);
        
        int[] dayslnMonths = {31,28 + highYear,31,30,31,30,31,31,30,31,30,31};
        
        String[] months = {"January", "February", "March", "April","May","June","July","August",
            "September","October","November","December"};
               
        int tempday = 0;
        for(int i=0;i<dayslnMonths.length;i++) {
            tempday+=dayslnMonths[i];
            if(tempday>dayNum) {
                isDay = tempday - dayNum;
                isMonth = months[i];
                break;
            }
        }
        
        System.out.println("Месяц: " + isMonth + ", Число: " + isDay);
    }
    
    protected int inter(String strInter, String strError,int numStart, int numEnd) {
        int returnnum =0;
        System.out.println(strInter);
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {            
            if(sc.hasNextInt() && ((returnnum = sc.nextInt())>=numStart) && (returnnum<=numEnd)) {
                break;
            } else System.out.println(strError);
        }
        
        return returnnum;
    }
}
 