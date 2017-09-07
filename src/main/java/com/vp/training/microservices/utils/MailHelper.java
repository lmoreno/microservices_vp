package com.vp.training.microservices.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class MailHelper {
	private static Logger log = Logger.getLogger(MailHelper.class);

	private static Properties propsMail = new Properties();
	private static String user = "";
	private static String password = "";

	public static void initialize() {
		propsMail.setProperty("mail.smtp.host", "smtp.gmail.com");
		propsMail.setProperty("mail.smtp.starttls.enable", "true");
		propsMail.setProperty("mail.smtp.port", "587");
		propsMail.setProperty("mail.smtp.auth", "true");
		user = "vpctests@gmail.com";
		password = "vpc123456";
	}

	/**
	 * Basic utility to send a mail
	 * 
	 * @param mailBody
	 * @param destinataries
	 */
	public static void sendMail(String mailBody, String destinataries) {
		try {
			if (propsMail.isEmpty()) {
				initialize();
			}

			List<String> destinatariesList = Arrays.asList(destinataries.split(","));

			Session session = Session.getDefaultInstance(propsMail);
			session.setDebug(false);

			MimeMessage message = new MimeMessage(session);
			BodyPart texto = new MimeBodyPart();

			texto.setText(mailBody);

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			message.setFrom(new InternetAddress("Training-microServices"));

			for (String destinatario : destinatariesList) {
				if (!destinatario.trim().isEmpty()) {
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
				}
			}

			message.setSubject("Training microServices");
			message.setContent(multiParte);

			Transport t = session.getTransport("smtp");
			t.connect(user, password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (MessagingException e) {
			log.error("Critical error sending mail: " + e.getMessage(), e);
		}
	}
}
