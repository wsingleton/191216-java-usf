package com.revature.quizzard.services;

import com.revature.quizzard.models.User;
import com.revature.quizzard.util.ApplicationProperties;
import com.revature.quizzard.util.MailerFactory;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.email.EmailPopulatingBuilder;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.converter.EmailConverter;
import org.simplejavamail.email.EmailBuilder;

import javax.mail.internet.MimeMessage;

import static com.revature.quizzard.util.ApplicationProperties.*;

public class MailService {

    private static final MailService MAIL_SERVICE = new MailService();
    private static final MailerFactory MAILER_FACTORY = MailerFactory.getInstance();

    private MailService() {
        super();
    }

    public static MailService getInstance() {
        return MAIL_SERVICE;
    }

    public void sendAccountConfirmationEmail(User newUser) {

        Mailer mailer = MAILER_FACTORY.buildMailer();

        EmailPopulatingBuilder emailBuilder = EmailBuilder.startingBlank();
        emailBuilder.from("Quizzard", ApplicationProperties.APP_SMTP_EMAIL);
        emailBuilder.to(newUser.getFirstName() + newUser.getLastName(),newUser.getEmail());
        emailBuilder.withSubject("Confirm Your New Quizzard Account!");

        String confirmationUrl = String.format("%s/confirmation?userId=%s", APP_URL, newUser.getId());
        String emailContent = String.format("<div>" +
                                                "<h3>Thank you for signing up for Quizzard!</h3>" +
                                                "<p>" +
                                                    "Click the following link to confirm your account: " +
                                                    "<a href=\"%s\">Confirm your account</a>" +
                                                "</p>" +
                                            "</div>", confirmationUrl);

        emailBuilder.withHTMLText(emailContent);

        Email baseEmail = emailBuilder.buildEmail();
        MimeMessage mimeMessage = EmailConverter.emailToMimeMessage(baseEmail);
        Email confirmationEmail = EmailConverter.mimeMessageToEmail(mimeMessage);
        mailer.sendMail(confirmationEmail);

    }
}
