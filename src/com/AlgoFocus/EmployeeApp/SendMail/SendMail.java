package com.AlgoFocus.EmployeeApp.SendMail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public void sendMailToCandidate(String fname, String mname, String lname,
			String dateofbirth, String email,
			String Mobilenumber, String highQual, String highestPerc,
			String graduation, String degreePerc, String puc, String pucPerc,
			String sslc, String sslcPerc, String resume) {

		try {
			final String fromEmail = "candidatestab@gmail.com";
			final String password = "preparation";
			final String ToEmail = email;

			Properties property = new Properties();
			property.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			property.put("mail.smtp.host", "smtp.gmail.com");// SMTP Host
			property.put("mail.smtp.port", "587"); // TLS Port
			property.put("mail.smtp.auth", "true"); // enable authentication
			property.put("mail.smtp.starttls.enable", "true");// enable STARTTLS

			Authenticator authenticate = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};

			Session sess = Session.getInstance(property, authenticate);

			MimeMessage msg = new MimeMessage(sess);
			System.out.println(msg.getSender());
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					ToEmail));

			msg.setSubject(" Hi " + fname + " " + mname + "  ");
			msg.setText("You have successfully Registered. Here are your Details\n" +
			"FirstName : "+fname+"\n" +" Resume : "+resume+"\n" +
					"Date Of Birth:" + dateofbirth+ "\n" + "Email Id:" +email +"\n" );

			Transport transport = sess.getTransport("smtp");
			transport.send(msg);

		} catch (MessagingException e) {
			
			System.out.println(e);
			e.printStackTrace();
		}

	}
}
