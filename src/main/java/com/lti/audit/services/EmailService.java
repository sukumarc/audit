package com.lti.audit.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender jMailSender;
	@Autowired
	private Configuration freemarkerConfig;

	public void sendSimplemessage() throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {

		MimeMessage message = jMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Template tmpt = freemarkerConfig.getTemplate("email-template");
		String htmlTemp = FreeMarkerTemplateUtils.processTemplateIntoString(tmpt, freemarkerConfig);
		helper.setTo("thyagarajan.rangaramanujam@lntinfotech.com");
		helper.setText(htmlTemp, true);
		jMailSender.send(message);
	}
}
