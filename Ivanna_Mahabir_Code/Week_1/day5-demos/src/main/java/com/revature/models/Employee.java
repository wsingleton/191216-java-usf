package com.revature.models;

public class Employee extends Thread {

    public Employee(){
        super();
    }

    public Employee(Runnable runnable){
        super(runnable);
    }

    @Override
    public void run(){
        for(int i=0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "is working...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
