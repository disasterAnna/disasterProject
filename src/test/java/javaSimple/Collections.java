package javaSimple;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {

    //массивы - массив int
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0]=1;
        nums[1]=1;
        nums[2]=1;

        //выброс предполагаемой ошибки
        try {
            nums[3]=1;
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        } finally {
            System.out.println("oops!");
        }


        System.out.println(nums[2]);

        //массив строк
        String[] str = {"2", "4", "8"};
        System.out.println(str[1]);

        //Коллекции
        ArrayList<String> list = new ArrayList<>();
        list.add("Абыр-абыр");
        list.add("Абырвалг");
        list.add("Мы их душили-душили!");

        //Перебор всех значений коллекции
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }

        //Вариант упрощённый
        for (String s : list){
            System.out.println("ForEach = "+s.length());
        }

        //Лямбда-выражения
        list.forEach(s -> System.out.println("strim = "+s));

        //Фильтрация со стримом по длине строк
        list.stream().filter(s -> s.length()<14).forEach(s -> System.out.println("filtered = " +s));

        //Фильтрация по строкам
        list.stream().filter(s -> s.contains("а")).forEach(s -> System.out.println("filtered too = " +s));

        //Эта запись делает то же, что и верхняя
        for (String s : list){
            if(s.contains("г")){
                System.out.println(s);
            }
        }

        //Сохранение в новую коллекцию
        ArrayList<String> secondList = (ArrayList<String>) list.stream().filter(s -> s.length() < 14).collect(Collectors.toList());
        //List<String> secondList2 = list.stream().filter(s -> s.length()<14).collect(Collectors.toList());
        secondList.forEach(s -> System.out.println("Second list item = "+s));

        //коллекция ключей-значений через HashMap
        HashMap<String,String> map = new HashMap<>();
        map.put("Key1", "Value1");

        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        map.put("Key4", "Value4");
        map.put("Key1", "Как дела-то?");
        System.out.println(map.get("Key1"));

        //set - обычное математическое множество. Перебираем ключи
        Set<String> set;
        set=map.keySet();
        set.forEach(s -> System.out.println("keys = "+s));

        //Перебираем ключи через for, способ 1
        for (String s:set){
            System.out.println("Значение ключа " + s + "= " + map.get(s));
        }

        //Перебираем ключи через for, способ 2
        for (Map.Entry<String,String> m: map.entrySet()){
            System.out.println("Key = " + m.getKey());
            System.out.println("Value = " + m.getValue());
        }


    }
}