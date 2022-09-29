package com.app.utility;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.app.pojos.Cart;
import com.app.pojos.Orders;

public class GetPassword {


	public void sendEmail(String to,String o) {
		
		System.out.println("in TLS EMAIL");
		final String fromEmail = "mgmalumninetwork@gmail.com"; //requires valid gmail id
		final String password = "pdzkifkepflfqkbr"; // correct password for gmail id
		final String toEmail = to; // can be any email id 
		String msgbody="Thanks For having Account with Gift Mania As you requested Your Password="+o;
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"Order Confirmation", msgbody);
		
	}

	
}

