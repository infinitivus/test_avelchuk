package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail implements IEmail {

    @Override
    public boolean sendMessageEmailRegistration(String emailTo, String password) { // отправляем письмо на email(необходимо выключить антивирус и брандмауер

        final String from = "email"; // record a real name from yandex mail
        final String pass = "password"; // record a real passport from yandex mail
        final String host = "smtp.yandex.ru";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.quitwait", "false");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pass);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject("Письмо авторизации");
            message.setContent("<h3>Пожалуйста авторизируйтесь кликнув по ссылке</h3>" +
                    "<a href=http://localhost:9000/authorisation?email=" +
                    emailTo + "&password=" + password, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }
}
