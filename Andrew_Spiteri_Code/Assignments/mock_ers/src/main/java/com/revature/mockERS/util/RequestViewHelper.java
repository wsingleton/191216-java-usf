package com.revature.mockERS.util;

public class RequestViewHelper {

    public static String process(String uri){
        switch (uri){
            case "/ers-app/login.view":
                return "partials/login.html";
            case "/ers-app/register.view":
                return "partials/register.html";
            case "/ers-app/dashboard.view":
                return "partials/basic-dashboard.html";
            default:
                return "";
        }
    }
}
