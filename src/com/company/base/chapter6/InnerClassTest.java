package com.company.base.chapter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

/**
 * 6.4 内部类
 */
public class InnerClassTest {
    private int delay = 0;
    private boolean beep;

    public InnerClassTest(int delay, boolean beep) {
        this.delay = delay;
        this.beep = beep;
    }

    public void start(){
        // lambda 表达式
        Timer timer = new Timer(delay, event -> {
            System.out.println(new Date() + ",声音响起");
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                }
        });
        timer.start();

        // 匿名内部类
//        ActionListener actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(new Date() + ",声音响起");
//                // if (InnerClassTest.this.beep)
//                if (beep){  // 内部类可以访问外围类的变量属性 beep
//                    Toolkit.getDefaultToolkit().beep();
//                }
//            }
//        };

        // ActionListener a = this.new PrintTimer();  this.new  创建内部类实例对象
//        ActionListener actionListener = new PrintTimer();
//        Timer timer = new Timer(delay, actionListener);
//        timer.start();
    }

    public static void main(String[] args) throws IOException {

        InnerClassTest inner = new InnerClassTest(1000, true);
        inner.start();

        System.in.read();
    }


    public class PrintTimer implements ActionListener {
        private int age;

        public PrintTimer(int age) {
            this.age = age;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(new Date() + ",声音响起");
            // if (InnerClassTest.this.beep)
            if (beep){  // 内部类可以访问外围类的变量属性 beep
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
