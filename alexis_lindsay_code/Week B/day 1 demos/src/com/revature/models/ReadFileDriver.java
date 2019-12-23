package com.revature.models;

import java.io.File;

public class ReadFileDriver { public static void main(String[] args){
    File happyText = new File("src/resources/readme.txt");
    System.out.println("Does the file exist? :: " +happyText.exists());



}
}
