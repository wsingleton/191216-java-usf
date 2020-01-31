package com.revature.reimbursement_app.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/reimbursements/login.view":
                return "partials/login.html";
            case "/reimbursements/register.view":
                return "partials/register.html";
            case "/reimbursements/login/dashboard":
                return "partials/dashboard.html";
            case "/reimbursements/home.view":
                return "partials/home.html";
            default:
                return "";

        }

    }

}
