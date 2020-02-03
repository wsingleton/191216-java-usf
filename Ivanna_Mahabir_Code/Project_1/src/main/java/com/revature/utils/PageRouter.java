package com.revature.utils;

public class PageRouter {

    public static String process(String uri){

        switch (uri){
            case "/Project_1/login.view":
                return "partials/login.html";
            case "/Project_1/register.view":
                return "partials/register.html";
            case "/Project_1/reimb.view":
                return "partials/dashboard.html";
            default:
                return "";
        }
    }
}
