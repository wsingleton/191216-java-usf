package com.revature.project1.util;

public class RequestViewHelper {

    public static String process(String uri){

        switch (uri){
            case "/Project1/home.view":
                return "partials/home.html";
            case "/project1/login.view":
                return "partials/login.html";
            default:
                return "";
        }
    }
}
