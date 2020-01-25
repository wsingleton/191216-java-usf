package com.revature.ers.util;

public class RequestViewHelper {
    public static String process(String uri) {
        switch (uri) {
            case "/ers/login.view":
                return "partials/login.html";
            case "/ers/dash.view":
                return "partials/dash.html";
            default:
                return "";
        }
    }
}
