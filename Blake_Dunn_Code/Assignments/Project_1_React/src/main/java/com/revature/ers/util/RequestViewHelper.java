package com.revature.ers.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestViewHelper {

    private static final Logger LOG = LogManager.getLogger(RequestViewHelper.class);

    public static String process(String uri) {
        LOG.info("URI received, attempting to redirect");
        switch (uri) {
            case "/project_1_ERS/home.view":
                return "partials/home.html";
            case "/project_1_ERS/login.view":
                return "partials/login.html";
            case "/project_1_ERS/register.view":
                return "partials/register.html";
            case "/project_1_ERS/dashboard.view":
                return "partials/dashboard.html";
            case "/project_1_ERS/request.view":
                return "partials/request.html";
            case "/project_1_ERS/policy.view":
                return "partials/policy.html";
            case "/project_1_ERS/info.view":
                return "partials/info.html";
            case "/project_1_ERS/admininfo.view":
                return "partials/adminupdate.html";
            case "/project_1_ERS/admindash.view":
                return "partials/admindash.html";
            default:
                LOG.warn("URI, {}, was invalid!", uri);
                return "";
        }
    }
}
