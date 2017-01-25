/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author awarsyle
 */
public class WebMailService {
    /**
     * 
     * @param to
     * @param subject
     * @param template
     * @param contents
     * @throws IOException
     * @throws MessagingException
     * @throws NamingException 
     */
    public static void sendMail(String to, String subject, String template, HashMap<String, String> contents) throws IOException, MessagingException, NamingException {
        String body;
        body = new String(Files.readAllBytes(Paths.get(template)));
        
        for(String key : contents.keySet()) {
            body = body.replace("{{" + key + "}}", contents.get(key));
        }
        
        sendMail(to, subject, body, true);
    }
    
    /**
     * 
     * @param to
     * @param subject
     * @param body
     * @param bodyIsHTML
     * @throws MessagingException
     * @throws NamingException 
     */
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException, NamingException {
        Context env = (Context)new InitialContext().lookup("java:comp/env");
        String username = (String)env.lookup("webmail-username");
        String password = (String)env.lookup("webmail-password");
        
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mai.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }
        
        // address the message
        Address fromAddress = new InternetAddress("cprg352@gmail.com");
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        // send the message
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
