package com.revature.util;

public class ViewHelper {
    public static String process (String uri) {
        switch (uri) {
            case "/XND_INC/login.view":
                return "partials/login.html";

                case "/XND_INC/user.view":
                    return "partials/user.html";

            case "/XND_INC/manager.view":
                return "partials/manager.html";

            default:
                return"";

        }
    }
}
