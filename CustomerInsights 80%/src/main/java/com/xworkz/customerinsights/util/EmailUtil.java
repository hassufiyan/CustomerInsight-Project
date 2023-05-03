package com.xworkz.customerinsights.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;



public class EmailUtil {
	
	public static Session sendMail() {
		String userName="hasansufiyan037@outlook.com";
		String password="Outlookvalid!123";
		
		Properties properties=new Properties();
		
		properties.put("mail.smtp.host","smtp.outlook.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		
		
		Session session =Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
		}
		});
		
//		 MimeMessage msg = new MimeMessage(session);
		return session;
		
	
		
}
}
