package com.revature.models;

public class Employee extends Thread {

    public Employee(){
        super();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " is working");
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
        System.out.println(Thread.currentThread().getName() + " is done.");

    }
}
