package com.ers.liberation.util;

public class RequestViewHelper {
    public static String process(String uri) {
        switch (uri) {
            case "/Project_1/login.view":
                return "partials/login.html";
            case "/Project_1/registerscreen.view":
                return"partials/registerscreen.html";
            case "/Project_1/dashboard.view":
                return "partials/dashboard.html";
            case "/Project_1/reimbursement.view":
                return "partials/reimbursement.html";
            case"/Project_1/employee_dashboard.view":
                return "partials/employee_dashboard.html";
            default:
                return "";
        }
    }
}
