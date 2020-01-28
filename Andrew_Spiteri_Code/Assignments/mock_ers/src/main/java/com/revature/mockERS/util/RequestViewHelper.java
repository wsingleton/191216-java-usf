package com.revature.mockERS.util;

import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {


    public static String process(HttpServletRequest req){

        ERS_Users authUser = (ERS_Users) req.getSession(false).getAttribute("this-user");


        switch (req.getRequestURI()){
            case "/ers-app/login.view":
                return "partials/login.html";
            case "/ers-app/register.view":
                return "partials/register.html";
            case "/ers-app/dashboard.view":
                System.out.println("Line 1");
                if(authUser.getRole().equals(ERS_User_Roles.FINANCE_MANAGER)){
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
