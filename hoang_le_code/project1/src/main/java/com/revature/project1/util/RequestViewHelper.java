package com.revature.project1.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/project1/login.view":
                return "partials/login.html";
            case "/project1/register.view":
                return "partials/register.html";
            case "/project1/login/dashboard":
                return "partials/dashboard.html";
            case "/project1/home.view":
                return "partials/home.html";
            case "/project1/registerSuccess.view":
                return "partials/registerSuccess.html";
            case "/project1/employee.view":
                return "partials/employee.html";
            case "/project1/manager.view":
                return "partials/manager.html";
            case "/project1/createReimb.view":
                return "partials/createReimb.html";
            case "/project1/update.view":
                return "partials/update.html";

            default:
                return "";
        }
    }
}
