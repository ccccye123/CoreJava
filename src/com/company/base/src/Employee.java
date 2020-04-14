package com.company.base.src;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 4.3节用户自定义类
 *
 * 源文件名应该和public的类名一致
 */
public class Employee {
    /**
     * 名字
     */
    private String name;
    /**
     * 薪水
     */
    private Double salary;
    /**
     * 入职日期
     */
    private LocalDate hireDay;

    /**
     * 构造函数，new后被自动执行
     * 和类同名
     * 至少有1个构造函数（不写使用默认构造函数）
     * 构造函数可以有0个以上的参数
     * @param name
     * @param salary
     * @param hireDay
     */
    public Employee(String name, Double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    /**
     * 基于类的访问权限，书4.3.7
     * @param obj
     * @return
     */
    public boolean equals(Employee obj) {
        // 注意 obj.name，在方法内可以直接访问 obj 的私有变量，因为 private访问修饰符
        return this.name.equals(obj.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * 增加薪水
     * @param percent
     */
    public void raiseSalary(Double percent){
        salary += salary*percent/100;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    /**
     * 注意：如果返回了引用类型的对象，并且该类型有更改器方法，那么就存在对象内部变量被外部修改的风险
     * 例如： Date 类型，有setTime()
     * 解决方案，返回时  clone 返回副本
     * @return
     */
    public LocalDate getHireDay() {
        return hireDay;
    }
}

// 不允许在一个Java文件最多有1个public类
//public class innerClass{
//
//}

// 允许的，这是内部类
class innerClass{

}
