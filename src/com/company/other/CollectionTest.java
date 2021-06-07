package com.company.other;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        // List 有序、可重复
        // 代表是 ArrayList，还有 LinkedList、Stack、Vector

        // ArrayList特点是查询快，增删慢，可随机访问
        List<String> arrayList = new ArrayList();
        ArrayList a = new ArrayList();

        funList(arrayList, "ArrayList");

        System.out.println("");

        // LinkedList 增删快，查询慢
        List<String> linkedList = new LinkedList<>();
        funList(linkedList, "LinkedList");

        System.out.println("");

        // Vector 线程安全，但是性能差
        List<String> vector = new Vector<>();
        funList(vector, "vector");

        System.out.println("");
        List<String> stack = new Stack<>();
        funList(stack, "stack");

    }

    private static void funList(List<String> list, String className){
        list.add("jack");
        list.add("jack");
        list.add(null);
        list.add(null);
        System.out.println(className+" :"+list);
        list.clear();
        list.add("jack1");
        list.add("jack22");
        list.add("jack11");
        list.add("jack1");
        System.out.println(className+" order:"+list);
        list.sort((s1,s2)->{
            return s2.length()-s1.length();
        });
        System.out.println(className+" sort:"+list);
    }
}
