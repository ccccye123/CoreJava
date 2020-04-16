package com.company.base.src;

import java.time.LocalDate;

public class Developer extends  Employee{
    /**
     * 构造函数
     *
     * @param name
     * @param salary
     * @param hireDay
     */
    public Developer(String name, Double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }
}
