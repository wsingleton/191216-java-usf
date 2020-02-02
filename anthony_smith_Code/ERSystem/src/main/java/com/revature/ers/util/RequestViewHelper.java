package com.revature.ers.util;

public class RequestViewHelper {

    public static String process(String uri){

        switch (uri){
            case "/ers/login.view":
                return "partials/login.html";

            case"/ers/user.view":
                return "partials/user.html";

            case"/ers/manager.view":
                return "partials/manager.html";



            default:
                return "";
        }
    }
}
