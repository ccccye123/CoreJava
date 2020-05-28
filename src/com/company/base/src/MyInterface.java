package com.company.base.src;

public interface MyInterface {
    static String fun(){
        return "Hello";
    }

    int say();

//    default int say(){
//        System.out.println("这是接口的默认方法");
//        return 0;
//    }
}
