package ru.geekbrains.java3.dz.dz3;

import java.io.*;
import java.util.Scanner;

public class Kursovaya_Java {
    /**
     * @param args the command line arguments
     */

    String[][] mas=new String[31][4];
    int i;
    int j;
    int max;
    String filename="";

    private void View(int num,String mas[][]) throws IOException {

        System.out.println("Id\tTip\t\tArtikul\tKolichestvo\tTsena");
        for(i=0;i<num;i++){
            if (mas[i][0].length()<8) {
                System.out.println(Integer.toString(i)+"\t"+mas[i][0]+"\t"+"\t"+mas[i][1]+"\t"+mas[i][2]+"\t"+mas[i][3]);
            }
            else {
                System.out.println(Integer.toString(i)+"\t"+mas[i][0]+"\t"+mas[i][1]+"\t"+mas[i][2]+"\t"+mas[i][3]);
            }

        }
    }
    public void Sort_by_type(int num,String mas[][]) throws IOException{

        String[] sortstr= new String[31];
        for (i=0;i<num;i++) {
            sortstr[i]=mas[i][0];
        }
        String temp="";
        for(j=0; j<num;j++){
            for (i=j+1 ; i<num; i++)
            {
                if(sortstr[i].compareTo(sortstr[j])<0)
                {
                    temp= sortstr[j];
                    sortstr[j]= sortstr[i];
                    sortstr[i]=temp;

                }
            }
        }
        System.out.println("Id\tTip\t\tArtikul\tKolichestvo\tTsena");
        for(i = 0; i<num;i++) {
            for(j = 0; j<num;j++) {
                if (mas[j][0]==sortstr[i]) {
                    if (mas[j][0].length()<8) {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                    else {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                }
            }
        }

    }
    public void Sort_by_articl(int num,String mas[][]) throws IOException{

        String[] sortstr= new String[31];
        for (i=0;i<num;i++) {
            sortstr[i]=mas[i][1];
        }
        String temp="";
        for(j=0; j<num;j++){
            for (i=j+1 ; i<num; i++)
            {
                if(sortstr[i].compareTo(sortstr[j])<0)
                {
                    temp= sortstr[j];
                    sortstr[j]= sortstr[i];
                    sortstr[i]=temp;

                }
            }
        }
        System.out.println("Id\tTip\t\tArtikul\tKolichestvo\tTsena");
        for(i = 0; i<num;i++) {
            for(j = 0; j<num;j++) {
                if (mas[j][1]==sortstr[i]) {
                    if (mas[j][0].length()<8) {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                    else {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                }
            }
        }

    }
    private void Sort_by_number(int num,String mas[][]) throws IOException{
        int[] sortint=new int[31];
        for (i = 0; i<num;i++) {
            sortint[i]=Integer.parseInt(mas[i][2]);
        }
        //Arrays.sort(sortint);
        int tmp=0;
        for (i = 0; i<num;i++) {
            for(j = 0; j<num;j++){
                if (sortint[j]<sortint[j+1]){
                    tmp=sortint[j];
                    sortint[j]=sortint[j+1];
                    sortint[j+1]=tmp;
                }
            }

        }
        System.out.println("Id\tTip\t\tArtikul\tKolichestvo\tTsena");
        for(i = 0; i<num;i++) {
            for(j = 0; j<num;j++) {
                if (Integer.parseInt(mas[j][2])==sortint[i]) {
                    if (mas[j][0].length()<8) {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                    else {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                }
            }

        }
    }
    private void Sort_by_amount(int num,String mas[][]) throws IOException{

        int[] sortint=new int[31];
        for (i = 0; i<num;i++) {
            sortint[i]=Integer.parseInt(mas[i][3]);
        }
        int tmp=0;
        for (i = 0; i<num;i++) {
            for(j = 0; j<num;j++){
                if (sortint[j]<sortint[j+1]){
                    tmp=sortint[j];
                    sortint[j]=sortint[j+1];
                    sortint[j+1]=tmp;
                }
            }

        }
        System.out.println("Id\tTip\t\tArtikul\tKolichestvo\tTsena");
        for(i = 0; i<num;i++) {
            for(j = 0; j<num;j++) {
                if (Integer.parseInt(mas[j][3])==sortint[i]) {
                    if (mas[j][0].length()<8) {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                    else {
                        System.out.println(Integer.toString(j)+"\t"+mas[j][0]+"\t"+mas[j][1]+"\t"+mas[j][2]+"\t"+mas[j][3]);
                    }
                }
            }

        }
    }

    private void  Add_to_file(String filename) throws IOException{
        String type_of_expense="",articl="",number="",amount="";
        Scanner user_input = new Scanner( System.in );
        System.out.println("Enter a type of expense");
        type_of_expense=user_input.next();
        System.out.println("Enter an amount");
        amount=user_input.next();
        Writer output;
        output = new BufferedWriter(new FileWriter(filename,true));  //clears file every time
        output.append(type_of_expense+" "+articl+" "+number+" "+amount+"\n");
        output.close();
    }
    private void Remove_from_file(String filename,String mas[][],int num, int id) throws IOException{
        PrintWriter br=new PrintWriter(new FileWriter(filename));
        br.println();
        for(i=0;i<num;i++){
            if(i!=id){
                br.println(mas[i][0]+" "+mas[i][1]+" "+mas[i][2]+" "+mas[i][3]);
            }

        }
        br.close();
    }
    private void Edit_in_file(String filename,int num,String mas[][]) throws IOException{
        int id=0;
        String type_of_expense="", articl="",number="",amount="";
        Scanner user_input = new Scanner( System.in );
        int data = 0;
        String edit_data="";
        System.out.println("Vvedite id zapisi kotoruyu vy by hoteli otredaktirovat");
        id=user_input.nextInt();
        System.out.println("Type\tAmount");
        System.out.println(mas[id][0]+"\t"+mas[id][1]);
        System.out.println("Vvedite informatsiyu kotoruyu vy by hoteli izmenit");
        System.out.println("1 - Tip tovara");
        System.out.println("2 - Acrticl");
        System.out.println("3 - Kolichestvo");
        System.out.println("4 - Tsena");

        data=user_input.nextInt();
        switch (data) {
            case 1:{
                System.out.println("Vvedite tip tovara");
                type_of_expense=user_input.next();
                mas[id][0]=type_of_expense;
                break;
            }
            case 2:{
                System.out.println("Vvedite articl");
                type_of_expense=user_input.next();
                mas[id][1]=articl;
                break;
            }
            case 3:{
                System.out.println("Vvedite kolichestvo");
                amount=user_input.next();
                mas[id][2]=number;
                break;
            }
            case 4:{
                System.out.println("Vvedite tsenu");
                amount=user_input.next();
                mas[id][3]=amount;
                break;
            }
            default: break;
        }
        PrintWriter br=new PrintWriter(new FileWriter(filename));
        br.println();
        for(i=0;i<num;i++){
            br.println(mas[i][0]+" "+mas[i][1]+" "+mas[i][2]+" "+mas[i][3]);

        }
        br.close();


    }
    public static void main(String[] args) throws IOException {
        String filename="C:\\Users\\1\\Desktop\\Access_App\\Database\\Database.txt";
        int cmd=0;
        Scanner user_input = new Scanner( System.in );
        Kursovaya_Java scan_file=new Kursovaya_Java();
        int stop=0;
        while(stop==0){
            Scanner file = new Scanner(new File(filename));
            String str=file.nextLine();
            Scanner fromStr = new Scanner(str);
            int max=0;
            String[][] mas=new String[31][4];
            int i;
            int j;
            i=0;
            while (file.hasNextLine()){
                str=file.nextLine();
                fromStr = new Scanner(str);
                while(fromStr.hasNext()){
                    mas[i][0]=fromStr.next();
                    mas[i][1]=fromStr.next();
                    mas[i][2]=fromStr.next();
                    mas[i][3]=fromStr.next();
                }
                i++;
                max++;

            }
            System.out.println("1- абаОаБбаАаЖаЕаНаИаЕ аБаАаЗб аДаАаНаНбб");
            System.out.println("2- ааОаБаАаВаЛаЕаНаИаЕ аИаНбаОбаМаАбаИаИ");
            System.out.println("3- а аЕаДаАаКбаИбаОаВаАаНаИаЕ аИаНбаОбаМаАбаИаИ");
            System.out.println("4- аЃаДаАаЛаЕаНаИаЕ аИаНбаОбаМаАбаИаИ");
            System.out.println("аЁаОббаИбаОаВаКаА аПаО:");
            System.out.println("   5- баИаПб");
            System.out.println("   6- аАббаИаКбаЛб");
            System.out.println("   7- аКаОаЛаИбаЕббаВб");
            System.out.println("   8- баЕаНаЕ");
            System.out.println("ааВаЕаДаИбаЕ аКаОаМаАаНаДб: ");
            cmd=user_input.nextInt();
            switch(cmd){
                case 1:{
                    Kursovaya_Java view_data=new Kursovaya_Java();
                    view_data.View(max,mas);
                    break;
                }
                case 2:{
                    Kursovaya_Java add_record=new Kursovaya_Java();
                    add_record.Add_to_file(filename);
                    break;
                }
                case 3:{
                    Kursovaya_Java edit_record=new Kursovaya_Java();
                    edit_record.Edit_in_file(filename,max,mas);
                    break;
                }
                case 4:{
                    int id=0;
                    System.out.println("Type the id of data you would like to delete");
                    id=user_input.nextInt();
                    Kursovaya_Java delete_record=new Kursovaya_Java();
                    delete_record.Remove_from_file(filename, mas,max,id);
                    break;
                }
                case 5:{
                    Kursovaya_Java sort_type=new Kursovaya_Java();
                    sort_type.Sort_by_type(max,mas);
                    break;
                }
                case 6:{
                    Kursovaya_Java sort_articl=new Kursovaya_Java();
                    sort_articl.Sort_by_articl(max,mas);
                    break;
                }
                case 7:{
                    Kursovaya_Java sort_number=new Kursovaya_Java();
                    sort_number.Sort_by_number(max,mas);
                    break;
                }
                case 8:{
                    Kursovaya_Java sort_amount=new Kursovaya_Java();
                    sort_amount.Sort_by_amount(max,mas);
                    break;
                }
                case 0:{
                    stop=1;
                    break;
                }
            }
        }

    }
}