package org.practice.miscellaneous;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class IgnoreMe { // or not

    public static <T> void genericArray(T whatever)
    {

//        T whatIsThis = new T[3];  // ERROR

//        ArrayList<Integer>[] array = new ArrayList<>[5]; ERROR


        ArrayList<Integer>[] array = new ArrayList[5];
        for(int i = 0; i < array.length; i++){

            array[i] = new ArrayList<>();
        }



        array[0] = new ArrayList<>();
        array[0].add(4);
        array[0].add(43);

        array[2].add(6);

        System.out.println(Arrays.toString(array));
    }



    public static void overloading(Object obj){
        System.out.println("Object");
    }

    public static void overloading(String obj){
        System.out.println("String");
    }

    public static void stringInput(String... s){
        System.out.println(Arrays.toString(s));
    }

    public static void stringInput(String s){
        
        System.out.println(s);
    }

    public static List<Integer> getList(int[] array){
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        try{
            while(true){
                ans.add(array[i++]);
            }
        }catch (Exception e){
            return ans;
        }
    }

    public static List<int[]> listAsArray(int[]... list){
        List<int[]> result = new ArrayList<>();
        Collections.addAll(result, list);
        return result;
    }

    @SneakyThrows
    public static <T, R> R  map(T object, Class<R> resultType) {


        Field[] field = object.getClass().getDeclaredFields();
        Method[] methods =
        object.getClass().getMethods();

        System.out.println(methods[3].invoke(object));

//        System.out.println(field[1].get(object) +" "+field[0].get(object));

        System.out.println(Arrays.toString(methods));

        return null;
    }



}
