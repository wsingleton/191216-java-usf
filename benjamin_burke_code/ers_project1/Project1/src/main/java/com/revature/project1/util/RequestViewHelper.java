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
            case "/Project1/manager.view":
                return "/partials/manager.html";
            case "/Project1/new.view":
                return "partials/new.html";
            case "/Project1/reimb.view":
                return  "partials/reimb.html";
            case "/Project1/manNewReimb.view":
                return "partials/managerNewReimb.html";
            case "/Project1/completed.view":
                return "partials/completedReimb.html";

            default:
                return "";
        }
    }
}
