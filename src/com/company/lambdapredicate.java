package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class lambdapredicate {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Ram", 22);
        Employee emp2 = new Employee("Jayanth", 15);
        Employee emp3 = new Employee("Anshu", 10);
        Employee emp4 = new Employee("Chaithu", 25);
        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);

        //the problem of writing with lambda expression for if conditions is, each time we need to run loop. So, the alternative is predicate
        list.forEach((s) -> {
            if (s.getId() <= 20) {
                System.out.println(s.getName());
            }
        });

        list.forEach((s) -> {
            if (s.getId() >20) {
                System.out.println(s.getName());
            }
        });

        getRequiredDetails(list, s -> s.getId()<=20);
        getRequiredDetails(list, s -> s.getId()>20);

    }

    public static void getRequiredDetails(List<Employee> emp, Predicate<Employee> idLimit) {
        for (Employee employee: emp) {
            if (idLimit.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
