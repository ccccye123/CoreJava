package com.company.base.chapter3;


public class C3 {
    public static void main(String[] args) {

        {
            int a = (1 << 3);
            int b = (8 >> 3);
            int c = (8 >>> 3);
            int d = (-2 >> 1);
            int e = (-2 >>> 1); // 无视符号位，填充0，所以得到一个很大的正数
            System.out.println("a:"+a);
            System.out.println("b:"+b);
            System.out.println("c:"+c);
            System.out.println("d:"+d);
            System.out.println("e:"+e);
        }
    }
}
