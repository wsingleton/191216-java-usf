package com.revature.project1.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/Project1/home.view":
                return "partials/home.html";
            case "/Project1/login.view":
                return "partials/login.html";
            case "/Project1/register.view":
                return "partials/register.html";
            case "/Project1/dashboard.view":
                return "partials/dashboard.html";
            case "/Project1/reimbs.view":
                return "partials/reimb-table";
            case "/Project1/newreimb.view":
                return "Project1/newreimb.html";
            default:
                return "";
        }
    }
}
