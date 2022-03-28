package com.zerobase.fast_lms.components;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MailComponents {

	private final JavaMailSender javaMailSender;

	public void sendMailTest() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("jerryseo0306@gmail.com");
		msg.setSubject("안녕하세요 동인이에요");
		msg.setText("생에 첫 보내보는 자바 메일링");

		javaMailSender.send(msg);
	}

	public boolean sendMail(String mail, String subject, String text) {

		boolean result = false;
		MimeMessagePreparator msg = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelper.setTo(mail);
				mimeMessageHelper.setSubject(subject);
				mimeMessageHelper.setText(text, true);
			}
		};

		try {
			javaMailSender.send(msg);
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;

	}
}
