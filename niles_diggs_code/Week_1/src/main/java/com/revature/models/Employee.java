package com.revature.models;

//creating a thread by creating a class that extends Thread

public class Employee extends Thread {

    public Employee () {
        super();
    }

    public Employee(Runnable runnable) {
        super(runnable);
    }

    @Override // have to override the run method b.c by default the run method doesn't have anything useful inside of it
    public void run() {
        for (int i=0; i<10; i++) {

            System.out.println(Thread.currentThread().getName() + "is working...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "is done working...");

    }

}
