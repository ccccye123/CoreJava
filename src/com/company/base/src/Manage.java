package com.company.base.src;

import java.time.LocalDate;
import java.util.Date;

/**
 * 经理
 * 子类
 * extend继承Employee类，Manage类拥有父类的全部数据域和方法
 * 类设计原则：将通用的方法放在父类，具有特殊功能的方法放在子类实现
 *
 * Java不支持多继承，因此只能extend一个父类
 */
public class Manage extends Employee implements MyInterface{

    /**
     * 构造函数
     * 1、 父类没有不带参数的构造器，子类必须显式调用父类的构造器初始化，否则会代码检查错误   super
     * 2、 父类有不带参数的构造器，子类会自动调用父类的无参构造器
     * @param name
     * @param salary
     * @param hireDay
     */
    public Manage(String name, Double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }

    /**
     * 返回类型不是签名的一部分，覆盖重写方法时要保证返回类型是原类型或是其类型的子类
     * 可以是被覆盖的方法返回类型的子类 ？？ 有点懵，为什么不是任意类型，，，，
     * @return
     */
    @Override
    public Manage build() {
        return new Manage("bob", 10D, LocalDate.now());
    }


    //    @Override
//    public Developer build() {
//        return new Developer("bob", 10D, LocalDate.now());
//    }

    /**
     * 获取薪水
     * 覆盖父类的方法
     * 固定加 10 的薪水
     * @return
     */
    @Override  // @Override注解
    public Double getSalary() {
        Double baseSalary = super.getSalary();  // 访问父类的数据域或者方法使用  super. 表示去父类找
        baseSalary += 10D;
        return baseSalary;

        /*
        反例
        return salary + 10D;   访问父类数据域没有用   super.

        return super.salary  不能直接父类  private 修饰的数据域
         */
    }


    public static void main(String[] args) {
        Manage manage = new Manage("jack", 17000D, LocalDate.now());

        // 父类和接口都有say方法，java按照父类有限原则自动使用父类实现
        manage.say();
    }
}
