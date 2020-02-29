package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        new Thread(new CodeToRun()).start();


        //calling with anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running through anonymous inner class");
            }
        }).start();


        //lambda with multiple statements
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

        //With anonymous inner class
        doStringSTuff(new UpperConcat() {
            @Override
            public String upperAndConcate(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        },list.get(0).getName(),list.get(1).getName());

        //with lambda
        UpperConcat uc = (s1,s2) -> {
             String result = s1.toUpperCase() + " " + s2.toUpperCase();
            System.out.println(Main.class.getSimpleName());
             return result;
        };
        String sillyString = doStringSTuff(uc,list.get(0).getName(),list.get(1).getName());
        System.out.println(sillyString);

    }


    public final static String doStringSTuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcate(s1,s2);
    }
}



