package com.company.base;

import com.company.base.src.Employee;
import com.company.base.src.Manage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 第五章
 * 继承
 */
public class Chapter5 {
    public static void main(String[] args) {
        // 5.2 所有类的超类
        // Object是所有类的超类
        // Object 的主要方法  equals、hashcode、toString
        Object obj1 = new Object();
        Object obj2 = obj1;
        boolean b = obj1.equals(obj2); //默认equals方法是判断obj1和obj2所引用的对象是否为同一个，通常要重写equals通过子类的值来判断是否相等
        System.out.println(b);

        Employee employee = new Employee("jack", 10000D, LocalDate.now());
        Employee employee2 = new Employee("john", 10000D, LocalDate.now());
        b = employee.equals(employee);
        System.out.println(b);
        b = employee.equals(employee2);
        System.out.println(b);



        // 5.4 对象包装和装箱
        // 每一种基本类型都有对应的包装类，比如  int : Integer
        // List<int> list = new ArrayList<int>();  // List不允许使用基本类型
//        List<Integer> list = new ArrayList<>();
//        Integer.valueOf()

        // 自动装箱
//        list.add(1);  // 这个现象称为自动装箱，相当于   list.add(Integer.valueOf(1))
        // 自动拆箱
//        int abc = list.get(0);  // 相当于 list.get(0).intValue();

        // 5.5 可变参数
        //multiArgs("jack", "lll", "222", "asdasdas");

        // 5.6枚举
//        Size s = Size.valueOf("Small");
//        Size m = Size.Small;
//
//        System.out.println(m.equals(Size.Small));
//        System.out.println(m == Size.Small);
//
//        System.out.println(Size.Small.toString() + ":" + System.identityHashCode(Size.Small));
//        System.out.println(s.toString() + ":" + System.identityHashCode(s));
//        System.out.println(Size.MEDIUM.toString() + ":" + System.identityHashCode(Size.MEDIUM));
//        System.out.println(Size.LARGE.toString() + ":" + System.identityHashCode(Size.LARGE));
//        System.out.println(Size.EXTRA_LARGE.toString() + ":" + System.identityHashCode(Size.EXTRA_LARGE));

//        Integer a = 100;
//        Integer b = 1000;
//        Integer c = 100;
//        Integer d = 1000;
//        b == d  false  这里返回的是false




//        Employee e = new Manage("jack", 10D, LocalDate.now());
//        System.out.println(e.getSalary());  // 虽然e是 Employee类型，但是调用 getSalary()方法时实际会调用Manage的getSalary()
    }

    /**
     * 枚举
     *
     * 1. 每个元素都是一个对象实例
     *
     * 2. == 和 equals
     * 对于 ==
     *  作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
     *  作用于引用类型的变量，则比较的是所指向的对象的地址；
     *
     * 对于 equals：　　
     *  equals方法不能作用于基本数据类型的变量；
     *  如果没有对Object中equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址，反之则比较的是内容；
     *
     * 书上说“永远不需要调用枚举的equals方法”，根据以上的说明，在枚举类型中他们的表现是一致的，即该说法不认同
     *
     *  3. Integer i = 100;  初始化Integer
     *  会自动调用 Integer.valueOf(int i),当  -128-127 时，直接返回值，否则创建一个新对象返回
     *  为什么这样做？因为 -128-127的值使用率高，重复使用有助于减少内存申请提高运行速度
     */
    enum Size {
        Small,
        MEDIUM,
        LARGE,
        EXTRA_LARGE
    }

    /**
     * 可变参数
     *
     * @param person
     * @param args 只能是最后一个参数
     */
    private static void multiArgs(String person, Object... args){
        System.out.println("hi "+person);
        for (Object o : args){
            System.out.println(o);
        }
    }
}
