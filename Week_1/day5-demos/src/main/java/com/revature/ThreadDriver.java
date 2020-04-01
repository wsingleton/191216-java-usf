package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;

public class ThreadDriver {

    public static void main(String[] args) {

        /*
            Thread states

                - NEW
                - RUNNABLE
                    + READY
                    + RUNNING
                - WAITING
                - TIMED_WAITING
                - BLOCKED
                - TERMINATED
         */

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        System.out.println(e1.getPriority());
        System.out.println(e2.getPriority());

        e1.setPriority(10);

        // this does not create a new thread, it runs the logic of the run() method on the "main" thread
//        e1.run();

        // a new thread, called "Thread-0", is created and the logic on run() is ran on this thread
//        e1.start();
//        e2.start();

        /*
            .join() method

                Using join(), we tell our thread to wait until other threads complete their operation.
                Once those threads are terminated, the thread we invoked .join() on will "join" and
                complete its operation.

                There are overloaded versions of this method, which allows the developer the ability
                to tell a thread to pause for a specific amount of time before "joining" other threads
         */

        try {
            e1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread logic");

        //--------------------------------------------------------

        Customer c1 = new Customer();
//        c1.run();

        Thread t = new Thread(c1);
//        t.start();

        Employee e3 = new Employee(c1);
//        e3.start();

        // lambda expression representing an inline implementation of Runnable
        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("lambda thread is doing some stuff.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("lambda thread is done");

        });

        t2.start();

    }

}
