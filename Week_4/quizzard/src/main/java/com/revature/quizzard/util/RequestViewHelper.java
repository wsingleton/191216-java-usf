package com.revature.quizzard.util;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/login.view":
            case "/quizzard/login.view":
                return "partials/login.html";
            default:
                return "";
        }
    }
}
