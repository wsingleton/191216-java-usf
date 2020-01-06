package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;

public class ThreadDriver {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        System.out.println(e1.getPriority());
        System.out.println(e2.getPriority());

        e1.setPriority(10);
        //e1.run(); this does not create a new thread it run the logic of the run method on the "main" thread
        //start creates a new thread and then runs the run logic on the new thread not on the main one
        e1.start();

        e2.start();

        try{
            e1.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("main thread logic");
        //----------------------------------------------------------------------

//ways to create a thread
        //create a class that extends thread and override its run method
        //create an object that implements runnable(functional interface, forced to override the run method) and pass an instance of that runnabale instance to a new thread object
        Customer c1 = new Customer();

        c1.run();
        Thread t = new Thread(c1);
        t.start();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println("Doing stuff");
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("Lambda");
        });

        t2.start();

    }


}
