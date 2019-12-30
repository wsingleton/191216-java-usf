package com.revature;

import com.revature.models.User;
import com.revature.util.Service;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankDriver {

    public static void main(String[] args) throws IOException {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

        Service service = new Service();
       // service.addUser("Tyler", "Rubbert", "trubbert", "password", 350);
//        List<User> list = service.getUserList();
//        for(User s : list){
//            System.out.println(s);
//        }

        System.out.println("enter '1' to login, '2' to create new account");
        if (scanner.next().equals("1")){
            service.logIn();
        }
        else {
            service.signUp();
        }

        

    }

}
