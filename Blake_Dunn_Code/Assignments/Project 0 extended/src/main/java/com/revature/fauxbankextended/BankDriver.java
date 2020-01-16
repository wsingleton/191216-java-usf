package com.revature.fauxbankextended;

import com.revature.fauxbankextended.util.AppState;

public class BankDriver {

    /*
        +--- User Logins ---+

        - buhlakay9, k!llinit
        - spacemvn69, fly!inhigh
        - bossco96, str8ball!n
        - bigballer, l@kers4life
        - laxbro99, f!owbucket
        - Picklerick, !magodbro
        - Jessicaishot, !lovejessica
        - csheen35, w!nning7
     */

    private static AppState app = new AppState();

    public static void main(String[] args) {

        while (app.isAppRunning()) {
            app.getRouter().navigate("/home");
        }
    }

    public static AppState app() {
        return app;
    }
}

