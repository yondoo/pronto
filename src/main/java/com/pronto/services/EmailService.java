package com.pronto.services;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.BodyPart;
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

import org.apache.tapestry5.services.Context;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class EmailService {
	static Properties props = System.getProperties();
	static final String smtpHost = "smtp.gmail.com";
	static final String smtpPort = "465";
	static final String senderName = "Tableau";
	static final String senderEmail = "tester201604072032";
	static final String senderPassword = "veryStrong";
	
	@Inject
	private Context context;

	public boolean sendEmail(String emails, String subject, String body) {
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		try {
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);

			try {
				message.setFrom(new InternetAddress(senderEmail, senderName));
			} catch (UnsupportedEncodingException e) {
				return false;
				// e.printStackTrace();
			}
			message.addRecipients(Message.RecipientType.TO, emails);
			message.setSubject(subject, "UTF-8");
			// message.setContent(body, "text/html; charset=UTF-8");

			Multipart multipart = new MimeMultipart();

			BodyPart textPart = new MimeBodyPart();
			textPart.setContent(body, "text/html; charset=UTF-8");
			multipart.addBodyPart(textPart);

			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, senderEmail, senderPassword);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (AddressException e) {
			return false;
			// e.printStackTrace();
		} catch (MessagingException e) {
			System.err.println(e);
			return false;
			// e.printStackTrace();
		}
		return true;
	}

	public String getTemplate(String templateName, Map<String, Object> dataModel) {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		try {
			cfg.setDirectoryForTemplateLoading(new File(context.getRealFile("/templates").getPath()));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			/* Get the template (uses cache internally) */
			Template temp = cfg.getTemplate(templateName);

			/* Merge data-model with template */
			Writer out = new StringWriter();
			temp.process(dataModel, out);
			return out.toString();
			// Note: Depending on what `out` is, you may need to call
			// `out.close()`.
			// This is usually the case for file output, but not for servlet
			// output.
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
