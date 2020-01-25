package com.revature.ers.util;

public class RequestNavHelper {
    public static String process(String uri) {
        switch (uri) {
            case "/ers/login.nav":
                System.out.println("Login.nav request received.  Calling lognav.html");
                return "partials/lognav.html";
            case "/ers/dash.nav":
                return "partials/dashnav.html";
            default:
                return "";
        }
    }
}
