package ru.geekbrains.java3.dz.dz7.MakosovAleksandr;

import ru.geekbrains.java3.dz.dz7.MakosovAleksandr.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Lesson7 {
    @AfterSuite
    public static void markerAfter(){
        System.out.println("AfterSuite");
    }
    @BeforeSuite
    public static void markerBefore(){
        System.out.println("BeforeSuite");
    }
    @Test(priority = 6)
    public void testing1(){
        System.out.println("Приоритет 6");
    }
    @Test(priority = 5)
    public void testing2(){
        System.out.println("Приоритет 5");
    }
    @Test(priority = 1)
    public void testing3(){
        System.out.println("Приоритет 1");
    }
    @Test
    public void testing4(){
        System.out.println("Приоритет по умолчанию 5");
    }

    public void testing5(){
        System.out.println("test");
    }


    public static void main(String[] args) {
        try {
            start(Lesson7.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class<?> c) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> list=new ArrayList<>();
        for(Method metod:methods){
            if(metod.isAnnotationPresent(Test.class)){
                int priority=metod.getAnnotation(Test.class).priority();
                if(priority<1 || priority>10) {
                    throw new RuntimeException("Значение приоритета: " + priority + " в методе "+metod.getName()+" недопустимо!");
                }
                list.add(metod);
            }
        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority()-o2.getAnnotation(Test.class).priority();
            }
        });
        boolean isBefore=false;
        boolean isAfter=false;
        for(Method metod : methods){
            if(metod.isAnnotationPresent(BeforeSuite.class)){
                //проверить, что повторений в анотации нет
                if(!isBefore) {
                    list.add(0, metod);
                    isBefore=true;
                } else{
                    throw new RuntimeException("Анотация "+metod.getAnnotation(BeforeSuite.class)+" в классе уже есть");
                }
            }
            if(metod.isAnnotationPresent(AfterSuite.class)){
                //проверить, что повторений в анотации нет
                if(!isAfter) {
                    list.add(metod);
                    isAfter=true;
                } else{
                    throw new RuntimeException("Анотация "+metod.getAnnotation(AfterSuite.class)+" в классе уже есть");
                }
            }

        }
        Object object=c.newInstance();
        for(Method m: list){
            m.invoke(object);
        }

    }
}
