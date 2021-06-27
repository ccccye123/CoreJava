package com.company.base.chapter3;

/**
 * 基本数据类型
 */
public class PrimitiveTypes {
    public static void main(String[] args) {
        // 2进制数表示方法，从java7开始支持
        byte binary1 = 0b1000;
        byte binary2 = 0B0100;
        System.out.println("binary1:"+binary1);  //binary1:8
        System.out.println("binary2:"+binary2);  //binary2:4

        // 16进制数表示方法
        byte hex = 0x0a;
        System.out.println("hex:"+hex); // 10

        // 8进制数表示方法
        byte oct = 010;
        System.out.println("oct:"+oct); // 8
    }
}
