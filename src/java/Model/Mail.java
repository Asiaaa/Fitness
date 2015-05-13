/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Joanna
 */
public class Mail {
   private static final String host="smtp.gmail.com";
    private static final int port=465;
    private static final String from="studio.urody.io@gmail.com"; //fitness.club.projekt@gmail.com
    private static final String password="studiourodyio"; // fitnessclubprojekt
    private String to;
    private String subject;
    private String text;
    
    public Mail(String tto, String ssubject, String ttext)
    {
        this.to=tto;
        this.subject=ssubject;
        this.text=ttext;
    }
    
    
    public void send() throws MessagingException
    {
        Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtps");
        prop.put("mail.smtps.auth", "true");
        
        Session session = Session.getDefaultInstance(prop);
        
        MimeMessage message = new MimeMessage(session);
        message.setSubject(this.subject);
        message.setContent(this.text, "text/plain; charset=ISO-8859-2");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
        
        Transport transport = session.getTransport();
        transport.connect(this.host, this.port, this.from, this.password);
        
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    } 
}
