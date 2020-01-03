package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;

import javax.swing.plaf.TableHeaderUI;

public class ThreadDriver {

    public static void main(String[] args) {

        /*
        Thread states

        -NEW
        -RUNNABLE
            Ready
            Running
        -WAITING
        -TIMED WAITING
        -BLOCKED
        -TERMINATE
         */


        Employee e1 = new Employee();
        Employee e2 = new Employee();


        System.out.println(e1.getPriority());
        System.out.println(e2.getPriority());

        e1.setPriority(10);

       // e1.run(); this does not create a new thread. it runs the logic of the run method on the main thread
        e1.start(); // a new thread, called "Thread-0" is created and the logic on run() is ran on this thread

        e2.start();

        /*
            .join() method

                using this method we tell our thread to wait until other thread(s) complete their operation.
                Once those threads are terminated the thread we invoked .join() on will "join" and finish its operation.

                There are overloaded versions of this method, which allow the developer the ability to tell a thread to
                pause for a specific amount of time before "joining" other threads.
         */

        try {
            e1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread logic");

        //------------------------------------------

        // another way to create a thread, is to create a class that implements runnable

        Customer c1 = new Customer();
        c1.run();

        Thread t = new Thread(c1);
        t.start();

       /* Employee e3 = new Employee(c1);
        e3.start(); */

       Thread t2 = new Thread(() -> {
           for(int i = 0; i <10; i++) {
               System.out.println("print some stuff..");
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
