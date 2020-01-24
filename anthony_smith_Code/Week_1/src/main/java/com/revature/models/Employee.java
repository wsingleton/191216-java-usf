package com.revature.models;

public class Employee extends Thread {
    public Employee(){
        super();
    }

    public Employee(Runnable runnable){
        super(runnable);
    }

    
}
