package com.revature.models;

public class Customer implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " is working...");
            try{
                Thread.sleep(100);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is done working.");
    }
}
