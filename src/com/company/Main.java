package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        new Thread(new CodeToRun()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running through anonymous inner class");
            }
        }).start();

        new Thread(() -> {
            System.out.println("Running through lambda expression");
            System.out.println("you can write multiple statements");
        }).start();

        Employee emp1 = new Employee("Ram", 22);
        Employee emp2 = new Employee("Jayanth", 23);
        Employee emp3 = new Employee("Anshu", 21);
        Employee emp4 = new Employee("Chaithu", 25);
        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);

        //arranging in ascending order
        Collections.sort(list, Comparator.comparing(Employee::getName));
        for (Employee employee: list) {
            System.out.println(employee.getName());
        }


    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Running");
    }
}

class Employee {
    public String name;
    public int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
