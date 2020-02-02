package com.revature.reimbursement_app.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/reimbursements/login.view":
                return "partials/login.html";
            case "/reimbursements/register.view":
                return "partials/register.html";
            case "/reimbursements/dashboard.view":
                return "partials/dashboard.html";
            case "/reimbursements/home.view":
                return "partials/home.html";
            case "/reimbursements/managerDashboard.view":
                return "partials/managerDashboard.html";
            case "/reimbursements/viewReimb.view":
                return "partials/viewReimb.html";
            case "/reimbursements/createReimb.view":
                return "partials/createReimb.html";
            case "/reimbursements/manageReimb.view":
                return "partials/manageReimb.html";
            default:
                return "";

        }

    }

}
