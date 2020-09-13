package com.company.other;

import java.nio.ByteOrder;

public class CopyTest {


    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());

        // System.identityHashCode(Object) 方法可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法
        // 原始对象
//        Student stud = new Student("小明", "光明小学");
        Student stud = new Student();
        System.out.println(System.identityHashCode(stud.getName())+stud.getName());

        // 拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println(System.identityHashCode(clonedStud.getName())+clonedStud.getName());

        // 修改对象
        clonedStud.setName("我是小明同学");
        System.out.println(System.identityHashCode(clonedStud.getName())+clonedStud.getName());
    }

}
