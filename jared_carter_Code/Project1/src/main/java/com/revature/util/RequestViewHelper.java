package com.revature.util;

public class RequestViewHelper {
    public static String process(String uri) {

        switch (uri) {
            case "/ers/dashboard.view":
                return "partials/dashboard.html";
            case "/ers/login.view":
                return "partials/login.html";
            case "/ers/registe.view":
                return "partials/registe.html";
            case"/ers/reimbursement.view":
                return "partials/reimbursement.html";
            default:
                return "";
        }
    }
}
