package coreFramework;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;

//public class TestReportEmail {
//
//    public static void main(String[] args) {
//        // Build the email
//    	File file = new File(".\report-output\takamol\report.html");
//        DataSource dataSource = new FileDataSource(file);
//        org.simplejavamail.api.email.Email email = EmailBuilder.startingBlank()
//                .from("arjityadav7@gmail.com")
//                .to("yadavarjit@gmail.com")
//                .withSubject("Test Report")
//                .withPlainText("Please find attached the test report.")
//                .withAttachment("report.html",dataSource);
//                .build();
//        
//        // Build the mailer
//        Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "arjityadav7@gmail.com", "jtnnbzdpifukhmzc")
//                .buildMailer();
//
//        // Send the email
//        mailer.sendMail(email);
//    }
//}

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class TestReportEmail {
	public static void main(String[] args) {

		String to = "arjit.yadav@appcino.com";
		String from = "appcinoqa@gmail.com";
		String host = "smtp.gmail.com";
		String password = "nofbafficcsrdsgg";
		int port = 587;

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("Test Email With Attachment");

			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText("This is a test email with attachment.");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			String filename = "./report-output/takamol/report.html"; // Set the
																		// path
																		// to
																		// your
																		// file
																		// here
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(new File(filename).getName());
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Email with attachment sent successfully.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
