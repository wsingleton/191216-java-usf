package com.revature;

public class MainDriver {

    public static void main(String[] args){
        Vehicle vehicle1 = new Vehicle("GTI", "Silver", "2005", "Volkswagen", "800");

        //not good practice to directly access
//        System.out.println(vehicle1.name);
//        vehicle1.setName("City");
//        System.out.println(vehicle1.name);
//        vehicle1.setColor("Blue");
//        System.out.println(vehicle1.color);
//        vehicle1.setCompany("Ford");
//        System.out.println(vehicle1.company);

        System.out.println(vehicle1.getName());
        vehicle1.setColor("Blue");
        System.out.println(vehicle1.getColor());

        System.out.println(vehicle1.getSpeed());

    }
}
