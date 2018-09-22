package ru.geekbrains.java3.dz.dz6.GilAnton;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class J3Lesson6Gil {

    private static final Logger myLogger = Logger.getLogger(J3Lesson6Gil.class.getName());

//    private static Integer[] startArr = new Integer[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};
//    private static Integer[] startArr = new Integer[]{1,4,4,4,1,1,3};

//    public J3Lesson6Gil(Integer[] startArr, int keySearch) {
//        this.startArr = startArr;
//    }

    public static void main(String[] args){

//        Integer[] testArr = getArrayNumberAfterSplit(startArr, 4);
//        HashSet<Integer> checkNum = new HashSet<>();
//        checkNum.add(1);
//        checkNum.add(4);
//        System.out.println(checkContentArray(startArr, checkNum));
    }

    public static Integer[] getArrayNumberAfterSplit(Integer[] inArr, int keySearch){

        int indFoundKeySearch = Arrays.asList(inArr).lastIndexOf(keySearch);
        if(indFoundKeySearch == -1) {
            String msg = "Element " + keySearch + " not found in array";
            myLogger.log(Level.INFO, msg);
            throw new RuntimeException(msg);
        }

        return Arrays.copyOfRange(inArr, indFoundKeySearch + 1, inArr.length);
    }

    public static boolean checkContentArray(Integer[] checkArr, Set<Integer> checkNum){

        boolean checkResult = true;

        for(Integer elCheck : checkNum){
            if(Arrays.asList(checkArr).indexOf(elCheck) == -1) {
                checkResult = false;
                break;
            }
        }
        if(checkResult){
            if(checkNum.size() != new LinkedHashSet<>(new ArrayList(Arrays.asList(checkArr))).size()) checkResult = false;
        }

        return checkResult;

    }

}
