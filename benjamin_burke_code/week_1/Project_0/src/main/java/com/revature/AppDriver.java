package com.revature;

import com.revature.repos.AccountUserRepository;
import com.revature.services.AccountTypeService;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppDriver {
    public static void main(String[] args) {

        static {
            System.out.println("[LOG] - Initializing application...");

            appRunning=true;
            console = new BufferedReader(new InputStreamReader(System.in));

            final UserRepository userRepo = new UserRepository();
            final AccountUserRepository accRepo = new AccountUserRepository();

            final UserService userService = new UserService(UserService(userRepo, accRepo);
            final AccountTypeService accTypeService = new AccountTypeService(accRepo);


        }


    }
}
