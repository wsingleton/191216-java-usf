package com.revature.quizzard.util;

public class RequestViewHelper {

    public static String process(String uri){

        switch (uri){
            case "/quizzard/login.view":
                return "partials/login.html"; //no break statement needed the return prevents fallthrough
            case "/quizzard/register.view":
                return "partials/register.html";
            case "/quizzard/login/dashboard":
                return "partials/dashboard.html";
            default:
                return "";
        }
    }
}
