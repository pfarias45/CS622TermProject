package pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

import resume.Resume;

import javax.activation.*;  

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class sets up thread to email PDF to user's email
 */
public class PDFEmail implements Runnable {
	
	private Resume resume;
	private String username;
	
	public PDFEmail(Resume resume, String username) {
		this.resume = resume;
		this.username = username;
	}
	
	@Override
	public void run() {
		System.out.println("\nEmail being sent...");
		sendEmail();
        System.out.println("\nAwesome! Email with PDF was sent. Check your inbox.");   
	}	 
			 
	/**
	 * Desc: Method sends email with PDF attachment to user
	 * Param:
	 * Return:
	*/
	public void sendEmail() {
		String to= username;
		String from = "resumebuilderdonotreply@gmail.com";
		String pswd = "resumebuilder";
		
		 // session object      
        Properties properties = new Properties();  
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pswd);
                    }
                });

        // compose message 
        try {
        	 MimeMessage message = new MimeMessage(session);  
        	 
        	 // set recipients
             message.setFrom(from);     
             message.setRecipients(Message.RecipientType.TO, to);    
             message.setSubject("Hello From ResumeBuilder");
             
             // message
             BodyPart messagePart = new MimeBodyPart();     
             messagePart.setText("Attached is the PDF resume file named " + resume.getResumeName() 
             					+ ". Thanks for using ResumeBuilder!");
             
             // write PDF to output stream
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			 PDFGenerate.generatePDF(outputStream, null, resume);
			 
		
			 // attach pdf
			 byte[] bytes = outputStream.toByteArray();
			 ByteArrayDataSource data = new ByteArrayDataSource(bytes, "application/pdf");
			 MimeBodyPart attachment = new MimeBodyPart(); 
	         attachment.setDataHandler(new DataHandler(data));
	         attachment.setFileName(resume.getResumeName());      
             
             // add message and attachment      
             Multipart multipart = new MimeMultipart();    
             multipart.addBodyPart(messagePart);     
             multipart.addBodyPart(attachment);  
      
             message.setContent(multipart);        

             // send message    
             Transport.send(message);      
             
             outputStream.close();

         }
        
        catch (MessagingException e) {
        	System.out.println("Email not sent.");
        	e.printStackTrace();
        } 
        catch (IOException e) {
        	System.out.println("Email not sent.");
			e.printStackTrace();
		} 
        
	}

}
