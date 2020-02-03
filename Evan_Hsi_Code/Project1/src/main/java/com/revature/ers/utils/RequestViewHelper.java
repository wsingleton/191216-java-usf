package com.revature.ers.utils;

public class RequestViewHelper {

    public static String process(String uri) {

        switch (uri) {
            case "/project1/login.view":
                return "html/login.html";
            case "/project1/register.view":
                return "html/register.html";
            case "/project1/dashemp.view":
                return "html/dashemp.html";
            case "/project1/dashman.view":
                return "html/dashman.html";
            case "/project1/manage.view":
                return "html/manage.html";
            default:
                return "";
        }
    }
}
