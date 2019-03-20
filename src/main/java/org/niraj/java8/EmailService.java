package org.niraj.java8;


public class EmailService {

	public String sendMail(String p , Double v){
		System.out.println("Sending mail to "+ p + " of price " +v);
		return "MailSent to ->"+p;
	}
	
}
