package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {
    public static void main(String[] args) {
        Employee e1=new Employee();
        Employee e2=new Employee();
        System.out.println(e1.getPriority());
        System.out.println(e2.getPriority());
        e1.setPriority(1);
        e2.setPriority(10);
        e1.start();
        e2.start();
    }
}