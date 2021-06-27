package com.company.base.chapter6;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class C6Test {
    public static void main(String[] args) throws IOException {
        InnerClassTest inner = new InnerClassTest(100, true);
        ActionListener a = inner.new PrintTimer(3); // 创建public的内部类方法 1、创建外围类，2、 outer.new inner();

//        Predicate
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.removeIf(e -> e == null);


        Timer timer = new Timer(1000, event -> System.out.println(LocalDateTime.now()));
        timer.start();
//        TimePrinter p = new TimePrinter();
//        Timer timer = new Timer(1000, p);
//        timer.start();
//
        System.in.read();
    }


}
