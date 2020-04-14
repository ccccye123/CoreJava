package com.company.base;

import com.company.base.src.Employee;

import java.time.LocalDate;

/**
 * 第四章
 * 对象和类
 */
public class Chapter4 {


    public static void main(String[] args) {
//        printCalender();
        employeeTest();

    }

    /**
     * 测试Employee
     */
    private static void employeeTest(){
        Employee[] employees = new Employee[2];
        employees[0] = new Employee("jack", 10000D, LocalDate.of(2020, 7, 3));
        employees[1] = new Employee("john", 12000D, LocalDate.of(2020, 7, 4));

        for (Employee e : employees){
            e.raiseSalary(5D);

            System.out.println("name:"+e.getName() + ",salary:"+e.getSalary() + ",hireDay:"+e.getHireDay().toString());
        }

    }


    /**
     * 打印日历
     * 效果
     * Mon Tue Wed Thu Fri Sat Sun
     *           1   2   3   4   5
     *   6   7   8   9  10  11  12
     *  13* 14  15  16  17  18  19
     *  20  21  22  23  24  25  26
     *  27  28  29  30
     */
    private static void printCalender(){
        LocalDate date = LocalDate.now();

        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        LocalDate index = date.withDayOfMonth(1);

        // 打印星期头
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        // 打印月初空白星期
        for (int i=1;i<index.getDayOfWeek().getValue();i++){
            System.out.printf("%4s", "");
        }

        while (index.getMonthValue() == month){  // 循环跳出条件：不是该月
            // 打印日期序号（月），并补齐3字符
            System.out.printf("%3d",index.getDayOfMonth());
            if (index.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }

            // 下一天
            index = index.plusDays(1);

            // 如果下一天是星期一，换行
            if (index.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }
}
