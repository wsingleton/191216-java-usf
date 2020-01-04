package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ThreadDriver {


    /*

        Thread States:

            - NEW
            -RUNNABLE
                +READY
                +RUNNING
            -WAITING
            -TIMED_WAITING
            -BLOCKED
            -TERMINATED

     */
    public static void main(String[] args) {


        Employee e1 = new Employee();
        Employee e2 = new Employee();
        System.out.println(e1.getPriority());
        System.out.println(e2.getPriority());
        e1.setPriority(10);
        //This does not create a new thread, it runs the logic of the run() method on the main thread
        e1.run();

        //This creates a new thread called "Thread-0" that is run with the logic in run()
        e1.start();
        e2.start();

        /*

            .join() method

                Using join(), we tell our thread to wait until other thread(s) complete their operation.
                Once those threads are terminated, the thread we invoked .join() on will "join" and complete it's operation.

                There are overloaded versions, which allow us to chose a minimum amount of time before joining.

         */

        try {
            e1.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread logic");

        //---------------------------------------------------------------------------------------------

        Customer c1 = new Customer();
        c1.run();
        Thread t = new Thread(c1);
        t.start();

        Employee e3 = new Employee(c1);
        e3.start();

        // lambda expression representing an inline implementation of Runnable
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("doing some stuff.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });
        t2.start();

    }
}
