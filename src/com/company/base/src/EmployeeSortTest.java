package com.company.base.src;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeSortTest {

    public static void main(String[] args) {
        Collection c;
        // Collections  伴随类

        Employee employee = new Employee("jack", 17000D, LocalDate.now());
        Employee employee2 = new Employee("john", 12000D, LocalDate.now());
        Employee employee3 = new Employee("bob", 13000D, LocalDate.now());

        Employee[] employees = new Employee[3];
        employees[0] = employee;
        employees[1] = employee2;
        employees[2] = employee3;

//        Arrays.sort(employees);

        // 比较器+lambda表达式
//        Comparator<Employee> comparator = (e1, e2) -> (int) (e1.getSalary() - e2.getSalary());
//        Arrays.sort(employees, comparator);
        Arrays.sort(employees, (e1, e2)->Double.compare(e1.getSalary(), e2.getSalary()));



        for (Employee o : employees){
            System.out.println(o.toString());
        }
    }
}
