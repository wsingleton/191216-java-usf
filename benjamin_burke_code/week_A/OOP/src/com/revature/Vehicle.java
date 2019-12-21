package com.revature;

public class Vehicle {
    private String name = " ";
    private String color = " ";
    private String model = "";
    private String company = " ";
    private String engine = "800";

    public  Vehicle(){};
    //constructor overloading
    public Vehicle(String name, String color, String model, String company, String engine) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.company = company;
        this.engine = engine;



    }
    //Setters
    public void setName(String name){
        this.name=name;
    }

    public void setColor(String color){
        this.color=color;
    }

    public void setCompany(String company){
        this.company=company;
    }

    public void setEngine(String engine){
        this.engine=engine;
    }
    //getters
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getCompany(){
        return this.company;
    }
    //don't want to make a change to that class as its private
    private String getEngine(){
        return this.engine;
    }

    public int getSpeed(){
        String a = getEngine();
        if(a== "800"){
            return 90;
        } else {
            return 120;
        }
    }


}
