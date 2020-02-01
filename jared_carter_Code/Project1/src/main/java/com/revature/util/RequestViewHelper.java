package com.revature.util;

public class RequestViewHelper {
    public static String process(String uri) {

        switch (uri) {
            case "/ers/login.view":
                return "partials/login.html";
            case"/ers/employee.view":
                return "partials/employee.html";
            case"/ers/manager.view":
                return "partials/manager.html";
            default:
                return "";
        }
    }
}
