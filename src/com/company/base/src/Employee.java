package com.company.base.src;

import java.time.LocalDate;
import java.util.Date;
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
     * 年龄
     */
    private int age = 18;

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
    public boolean equals(Employee obj) {  // 这是一个错误示范，并没有重写 Object的equals方法
        // 注意 obj.name，在方法内可以直接访问 obj 的私有变量，因为 private访问修饰符
        return this.name.equals(obj.name);
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay, age);
    }

    @Override
    public boolean equals(Object o) {
        // 根据需要，判断 getClass 和 instanceOf
        // this.getClass() == o.getClass() 当this和o的类型一致返回true
        // obj instanceof Class  当 obj 为 Class 的对象，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name) &&
                salary.equals(employee.salary) &&
                hireDay.equals(employee.hireDay);
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

    public int getAge() {
        return age;
    }

    public Employee build(){
        return new Employee("john", 30D, LocalDate.now());
    }

    /**
     * 注意：如果返回了引用类型的对象，并且该类型有更改器方法，那么就存在对象内部变量被外部修改的风险
     * 例如： Date 类型，有setTime()
     * 解决方案1，返回时  clone 返回副本
     * 方案2，使用没有更改器的 LocalDate
     * @return
     */
    public LocalDate getHireDay() {
        return hireDay;
//        return (Date) hireDay.clone();
    }
}

// 不允许在一个Java文件最多有1个public类
//public class innerClass{
//
//}

// 允许的，这是内部类
class innerClass{

}
