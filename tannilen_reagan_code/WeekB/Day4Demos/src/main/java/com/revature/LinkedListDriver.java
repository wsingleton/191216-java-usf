package com.revature;
import com.revature.util.MyLinkedList;

public class LinkedListDriver {
    public static void main(String[] args) {
        MyLinkedList<String> mnemonicPlanets=new MyLinkedList<>();
        mnemonicPlanets.insert("My");
        mnemonicPlanets.insert("very");
        mnemonicPlanets.insert("educated");
        mnemonicPlanets.insert("mother");
        mnemonicPlanets.insert("just");
        mnemonicPlanets.insert("served");
        mnemonicPlanets.insert("us");
        mnemonicPlanets.insert("nine");
        mnemonicPlanets.insert("pies");

        System.out.println(mnemonicPlanets.peek());
        System.out.println(mnemonicPlanets.peek());
        System.out.println(mnemonicPlanets.poll());
        System.out.println(mnemonicPlanets.peek());
        mnemonicPlanets.removeByKey("served");
        mnemonicPlanets.printList();
    }
}
