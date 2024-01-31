package com.org.students.helper;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.org.students.dto.StudentDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSendingHelper {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendotp(StudentDetails details) {
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setFrom("thanushrihn.2000@gmail.com","sent");
			helper.setTo(details.getStudentemail());
			helper.setSubject("Sent result");
//			String body="<html><body><h1>"+details+"</h1></body></html>";
			String body="<html><body><table border='1px'><tr>"+"<th>ID</th>"+"<th>STUDENT NAME</th> "+" <th>PHONE NUMBER</th>"+" <th>EMAIL</th>"+
					"<th>WEB TECHNILOGY</th>"+" <th>CORE JAVA</th>"+"<th>ADVANCE JAVA</th>"+" <th>APTITUDE</th>"+"<th>SQL</th>"
							+ "<th>PERCENTAGE</th>"+"<th>TOTAL MARKS</th>"+"<th>RESULT</th>"+"</tr>"
							+"<tr>"+"<th>"+details.getId()+"</th>"+"<th>"+details.getStudentname()+"</th>"+"<th>"+details.getStudentphone()+"</th>"+"<th>"+details.getStudentemail()+"</th>"+"<th>"+details.getWeb()+"</th>"+"<th>"+details.getCorejava()+"</th>"+"<th>"+details.getAdvancejava()+"</th>"+"<th>"+details.getApti()+"</th>"+"<th>"+details.getMsql()+"</th>"+"<th>"+details.getPercentage()+"</th>"+"<th>"+details.getTotal()+"</th>"+"<th>"+details.getResult()+"</th>"
							+"</tr>"+ "</table></body></html>";
			helper.setText(body,true);
			mailSender.send(message);
			
		} catch(UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
