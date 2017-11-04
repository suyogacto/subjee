package com.suyoga.subjee.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class RandomEmail {
	
	
	public static void emailSystem(String toEmail,String Address,String msgText1,String orderNumber){
		
		try {
			String smtpHost = "localhost";
			/*String msgText1 ="";
			String smtpHost = "localhost";
			msgText1="<html><head></head><body>";
			msgText1 = msgText1+"<p class=MsoNormal><b><span style='font-size:10.0pt;font-family:'Verdana''>Hi Customer,</span></b><span style='font-size:12.0pt;font-family:'Verdana''><o:p></o:p></span></p>";
			msgText1 = msgText1+"<p class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto; text-align:justify'><span style='font-size:13.0pt;font-family:'Verdana''>Your order "+orderNumber+" has been successfully placed! </span></p>"; 
			
			msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> DELIVERY ADDRESS :</b>&nbsp;&nbsp;<br><br>";
			msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> "+Address+" </b>&nbsp;&nbsp;<br><br>";
			
			msgText1=msgText1+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Thank you beeing With us.</b>&nbsp;&nbsp;<br><br>";
			
			msgText1=msgText1+"</body></html>";*/
			
			String from = "support@suyoga.co.in";
			Properties props = System.getProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", smtpHost);
			Session session = Session.getInstance(props, null);
			session.setDebug(true);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, toEmail);
			msg.setSubject("Order "+orderNumber+" ");
			Multipart multipart = new MimeMultipart("related");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgText1, "text/html");
			multipart.addBodyPart(messageBodyPart);
			
			msg.setContent(multipart);
			msg.setSentDate(new Date());
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
