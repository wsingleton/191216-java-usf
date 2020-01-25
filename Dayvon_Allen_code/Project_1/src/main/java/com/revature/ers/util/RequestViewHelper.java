package com.revature.ers.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/ers/login.view":
                return "partials/login.html";
            case "/ers/home.view":
                return "partials/home.html";
            case "/ers/register.view":
                return "partials/register.html";
            case"/ers/dashboard.view":
                return "partials/dashboard.html";
            default:
                return "";
        }
    }
}
