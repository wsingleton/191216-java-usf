package com.ers.liberation.util;

public class RequestViewHelper {
    public static String process(String uri) {
        switch (uri) {
            case "/Project 1/login.view":
                return "partials/login.html";
            case "/Project 1/register.view":
                return"partials/register.html";
            case "/Project 1/dashboard.view":
                return "partials/dashboard.html";
            default:
                return "";
        }
    }
}
