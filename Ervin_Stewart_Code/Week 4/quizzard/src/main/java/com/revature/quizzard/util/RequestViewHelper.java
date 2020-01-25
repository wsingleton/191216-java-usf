package com.revature.quizzard.util;

public class RequestViewHelper {
    public static String process(String uri){
        switch(uri){
            case "/quizzard/login.view":
                return "partials/login.html";
            case "/quizzard/register.view":
                return "partials/register.html";
            case "/quizzard/dashboard.view":
                return "partials/dashboard.html";
            default:
                return "";
        }
    }
}
