package com.revature.quizzard.util;

import org.simplejavamail.api.mailer.config.TransportStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    public static final String APP_URL;
    public static final String APP_DB_URL;
    public static final String APP_DB_USR;
    public static final String APP_DB_PW;
    public static final String APP_SMTP_HOST;
    public static final Integer APP_SMTP_PORT;
    public static final String APP_SMTP_EMAIL;
    public static final String APP_SMTP_EMAIL_PW;
    public static final TransportStrategy APP_SMTP_TRANSPORT_STRATEGY;
    public static final Properties APP_PROPS = new Properties();

    static {

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("application.properties");
            APP_PROPS.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Boolean.parseBoolean(APP_PROPS.getProperty("app.prod"))) {
            APP_URL = APP_PROPS.getProperty("app.prod.url");
        } else {
            APP_URL = APP_PROPS.getProperty("app.local.url");
        }

        APP_DB_URL = APP_PROPS.getProperty("app.db.url");
        APP_DB_USR = APP_PROPS.getProperty("app.db.usr");
        APP_DB_PW = APP_PROPS.getProperty("app.db.pw");
        APP_SMTP_HOST = APP_PROPS.getProperty("app.smtp.host");
        APP_SMTP_PORT = Integer.parseInt(APP_PROPS.getProperty("app.smtp.port"));
        APP_SMTP_EMAIL = APP_PROPS.getProperty("app.smtp.email");
        APP_SMTP_EMAIL_PW = APP_PROPS.getProperty("app.smtp.email.pw");
        APP_SMTP_TRANSPORT_STRATEGY = TransportStrategy.SMTP;

    }

    private ApplicationProperties() {
        super();
    }

}
