package com.ljx.test;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {

	@Test
	public void contentLoads() {		
	}
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	/**
	 * 发送包含简单文本的邮件
	 */
	@Test
	public void sendTextMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人
		simpleMailMessage.setTo("18013873646@163.com");
		simpleMailMessage.setFrom("18013873646@163.com");
		simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
		simpleMailMessage.setText("这是一段简单文本");
		// 发送邮件
		mailSender.send(simpleMailMessage);
		System.out.println("邮件已发送");
	}
	
	/**
	 * 发送包含html文本的邮件
	 * @throws Exception
	 */
	@Test
	public void sendHtmlMail() throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
		mimeMessageHelper.setTo("18013873646@163.com");
		mimeMessageHelper.setFrom("18013873646@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>Spring 邮件测试</h1><p>Hello! This is spring mail test.</p></body>");
		sb.append("</html>");
		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);
		// 发送邮件
		mailSender.send(message);
		System.out.println("邮件已发送");
	}
	
	/**
	 * 发送包含内嵌图片的邮件
	 */
	@Test
	public void sendAttachedImageMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// multimart 模式
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setTo("18013873646@163.com");
		mimeMessageHelper.setFrom("18013873646@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【图片】");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head></head>");
		sb.append("<body>");
		sb.append("<h1>Spring 邮件测试</h1>");
		sb.append("<p>Hello! This is spring boot mail test</p>");
		sb.append("<img src=\"cid:imageId\"/></body>");
		sb.append("</body>");
		sb.append("</html>");
		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);
		// 设置imageId
		FileSystemResource img = new FileSystemResource(new File("D:/img/1.jpg"));
		mimeMessageHelper.addInline("imageId", img);
		// 发送邮件
		mailSender.send(mimeMessage);
		System.out.println("邮件已发送");	
	}
	
	/**
	 * 发送包含附件的邮件
	 */
	@Test
	public void sendAttendFileMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// multipart 模式
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setTo("18013873646@163.com");
		mimeMessageHelper.setFrom("18013873646@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【附件】");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head></head>");
		sb.append("<body>");
		sb.append("<h1>Spring 邮件测试</h1>");
		sb.append("<p>Hello! This is spring boot mail test</p>");
		sb.append("</body>");
		sb.append("</html>");
		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);
		// 设置附件
		FileSystemResource img = new FileSystemResource(new File("D:/img/1.jpg"));
		mimeMessageHelper.addAttachment("image.jpg", img);
		// 发送邮件
		mailSender.send(mimeMessage);
		System.out.println("邮件已发送");
	}
}