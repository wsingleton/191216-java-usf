package com.revature.utils;

public class PageRouter {

    public static String process(String uri){

        switch (uri){
            case "/Project_1/login.view":
                return "./partials/login.html";
            case "/Project_1/dashboard.view":
                return "./partials/dashboard.html";
            case "/Project_1/financeDisplay.view":
                return "./partials/financeDisplay.html";

            default:
                return "";
        }
    }
}
