package com.revature.mockERS.util;

import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestViewHelper {


    public static String process(HttpServletRequest req){

        HttpSession session = req.getSession(false);
        ERS_Users u = (session != null) ? (ERS_Users) session.getAttribute("this-user") : null;
        System.out.println(u);

        switch (req.getRequestURI()){
            case "/ers-app/login.view":
                System.out.println("case 1");
                return "partials/login.html";
            case "/ers-app/register.view":
                System.out.println("case 2");
                return "partials/register.html";
            case "/ers-app/dashboard.view":
                System.out.println("case 3");
                if(u.getRole().equals(ERS_User_Roles.FINANCE_MANAGER)){
                    System.out.println("case 3-1");
                    return "partials/admin-dashboard.html";
                }else{
                    System.out.println("case 3-2");
                    return "partials/basic-dashboard.html";
                }
            default:
                System.out.println("default case");
                return "";
        }
    }
}
