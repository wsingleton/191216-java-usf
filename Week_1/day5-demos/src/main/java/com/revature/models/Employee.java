package com.revature.models;

public class Employee extends Thread {

    public Employee() {
        super();
    }

    public Employee(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName() + " is working...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(Thread.currentThread().getName() + " is done working.");

    }
}
