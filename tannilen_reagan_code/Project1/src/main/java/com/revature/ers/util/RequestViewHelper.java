package com.revature.ers.util;

public class RequestViewHelper {
    public static String process(String uri) {
        switch (uri) {
            case "/ers/login.view":
                return "partials/login.html";
            case "/ers/dash.view":
                return "partials/dash.html";
            case "/ers/about.view":
                return "partials/about.html";
            case "/ers/createReq.view":
                return "partials/create.html";
            case "/ers/review.view":
                return "partials/review.html";
            default:
                return "";
        }
    }
}
