/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.utilities;


import java.io.BufferedReader;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Abdurrahman
 */
public class MailSender {


    public static void sendMail1(String to, String subject,String content, String smtp) throws AddressException, MessagingException {

        // String host = "smtp.mail.yahoo.com";
        final String user = "noreply@hyderabadmanpower.com";//change accordingly  
        final String password = "Noreply@1234$!";//change accordingly  

        //  String to = "sonoojaiswal1987@gmail.com";//change accordingly  
        //Get the session object  
        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.host", "mail.hydmanpower.com");
        props.put("mail.stmp.user", "noreply@hyderabadmanpower.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", "Noreply@1234$!");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            System.out.println(content);
            message.setSubject(subject);
            message.setText(content);
            message.setContent(content, "text/html");

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            String username = "user";
            String password = "password";
            return new PasswordAuthentication("username", "password");
        }
    }
}