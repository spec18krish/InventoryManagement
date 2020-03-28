/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common.Email;

import com.sun.mail.smtp.SMTPTransport;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Vidhya Mohan
 */
public class SMTPEmail {
    
        // for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String USERNAME = "imsaspire2@gmail.com";
    private static final String PASSWORD = "vidhya@aspire";

    private static final String EMAIL_FROM = "imsaspire2@gmail.com";
   // private static final String EMAIL_TO = "spec18krish@gmail.com, vidhya074@gmail.com";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP (HTML)";
    private static final String EMAIL_TEXT = "<h1>Hello Java Mail \n ABC123</h1>";
    
    public void sendEmail(String emailTo, String emailSubject, String emailBody) {
        Properties prop = System.getProperties();
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", SMTP_SERVER);
            prop.put("mail.smtp.user", EMAIL_FROM);
            prop.put("mail.smtp.password", PASSWORD);
            prop.put("mail.smtp.port", "587");
         //   prop.put("mail.smtp.auth", "true");
 

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);
        
         try {

        //    msg.setFrom(new InternetAddress(EMAIL_FROM));

            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo, false));

            msg.setSubject(emailSubject);
			
			// TEXT email
        //    msg.setText(EMAIL_TEXT);
             msg.setContent(emailBody, "text/html");
            

			// HTML email
       //     msg.setDataHandler(new DataHandler(new HTMLDataSource(EMAIL_TEXT)));

            
	    SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			
			// connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);
			
			// send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    
    
    public void sendEmail(String EMAIL_TO, String emailBody) {
       this.sendEmail(EMAIL_TO, EMAIL_SUBJECT, emailBody);
    }

    
}
