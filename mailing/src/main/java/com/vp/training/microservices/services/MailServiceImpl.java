package com.vp.training.microservices.services;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vp.training.microservices.entities.Mail;

@Service
public class MailServiceImpl implements MailService {

	private static Logger log = Logger.getLogger(MailServiceImpl.class);

	private Properties propsMail = new Properties();
	@Value("${mail.smtp.host}")
	private String smtp_host;
	@Value("${mail.smtp.starttls.enable}")
	private String smtp_starttls_enable;
	@Value("${mail.smtp.port}")
	private String smtp_port;
	@Value("${mail.smtp.auth}")
	private String smtp_auth;
	@Value("${mail.user}")
	private String user;
	@Value("${mail.password}")
	private String password;

	public void initMailConfig() {
		propsMail.setProperty("mail.smtp.host", smtp_host);
		propsMail.setProperty("mail.smtp.starttls.enable", smtp_starttls_enable);
		propsMail.setProperty("mail.smtp.port", smtp_port);
		propsMail.setProperty("mail.smtp.auth", smtp_auth);
	}

	public void sendMail(Mail mail) {
		try {
			initMailConfig();

			Session session = Session.getDefaultInstance(propsMail);
			session.setDebug(false);

			MimeMessage message = new MimeMessage(session);
			BodyPart texto = new MimeBodyPart();

			texto.setText(mail.getBody());

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			message.setFrom(new InternetAddress("MicroServices-training"));

			for (String destinatario : mail.getRecipients()) {
				if (!destinatario.trim().isEmpty()) {
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
				}
			}

			message.setSubject("MicroServices training");
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
