package com.revature.models;

public class Customer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + " is browsing...");
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has completed the operation.");
    }
}
