package com.revature.mockERS.util;

public class RequestViewHelper {


    public static String process(String uri){
        switch (uri){
            case "/ers-app/login.view":
                return "partials/login.html";
            case "/ers-app/register.view":
                return "partials/register.html";
            case "/ers-app/dashboard.view":
                System.out.println("Line 1");
                if(UserSession.isAdminOrManager()){
                    System.out.println("Line 2");
                    return "partials/admin-dashboard.html";
                }else{
                    System.out.println("Line 3");
                    return "partials/basic-dashboard.html";
                }
            default:
                return "";
        }
    }
}
