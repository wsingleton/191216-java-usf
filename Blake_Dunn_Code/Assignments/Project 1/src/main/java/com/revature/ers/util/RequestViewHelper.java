package com.revature.ers.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/project_1_ERS/home.view":
                return "partials/home.html";
            case "/project_1_ERS/login.view":
                return "partials/login.html";
            case "/project_1_ERS/register.view":
                return "partials/register.html";
            case "/project_1_ERS/dashboard.view":
                return "partials/dashboard.html";
            case "/project_1_ERS/reimbs.view":
                return "partials/reimb-table.html";
            case "/project_1_ERS/newreimb.view":
                return "partials/newreimb.html";
            case "/project_1_ERS/reimbupdate.view":
                return "partials/reimb-info.html";
            default:
                return "";
        }
    }
}
