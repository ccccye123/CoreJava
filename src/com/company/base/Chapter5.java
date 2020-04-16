package com.company.base;

import com.company.base.src.Employee;
import com.company.base.src.Manage;

import java.time.LocalDate;
import java.util.Date;

/**
 * 第五章
 * 继承
 */
public class Chapter5 {
    public static void main(String[] args) {
        Employee e = new Manage("jack", 10D, LocalDate.now());
        System.out.println(e.getSalary());  // 虽然e是 Employee类型，但是调用 getSalary()方法时实际会调用Manage的getSalary()
    }
}
