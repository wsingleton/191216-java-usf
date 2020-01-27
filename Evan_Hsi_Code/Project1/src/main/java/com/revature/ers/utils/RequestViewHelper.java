package com.revature.ers.utils;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/project1/home.view":
                return "partials/home.html";
            case "/project1/login.view":
                return "partials/login.html";
            case "/project1/register.view":
                return "partials/register.html";
            case "/project1/dashboard.view":
                return "partials/dashboard.html";
            case "/project1/newreimbursment.view":
                return "partials/newreimbursment.html";
            case "/project1/approvereimbursment.view":
                return "partials/approvereimbursement.html";
            default:
                return "";
        }
    }
}
