/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 7, 2015 4:00:51 PM
 */
package com.fred.cms.util;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component
public class MailUtil implements Serializable {

    public static final String ENCODING = "UTF-8";

    private static final long serialVersionUID = -9061088654793460208L;

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private VelocityEngine velocityEngine;

    public void sendEmail(String email, String subject, String mailContent) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("fred_test@163.com");
        mail.setSubject(subject);
        mail.setText(mailContent);
        mailSender.send(mail);
    }

    /**
     * 发送邮件
     * 
     * @param emailAddress
     *            收件人Email地址的数组
     * @param from
     *            寄件人Email地址, null为默认寄件人web@vnvtrip.com
     * @param bodyText
     *            邮件正文
     * @param subject
     *            邮件主题
     * @param attachmentName
     *            附件名
     * @param resource
     *            附件
     * @throws MessagingException
     */
    public void sendMessage(String[] emailAddresses, String from, String bodyText, String subject,
            String attachmentName, ClassPathResource resource) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailAddresses);
        helper.setFrom(from);
        helper.setText(bodyText, true);
        helper.setSubject(subject);

        if (attachmentName != null && resource != null) {
            helper.addAttachment(attachmentName, resource);
        }
        mailSender.send(message);
    }

    public void sendEmail(String email, String subject, String templateLocation, Map<String, Object> map) {

        String content = generateEmailContent(templateLocation, map);
        sendEmail(email, subject, content);
    }

    // generate email content.
    public String generateEmailContent(String templateLocation, Map<String, Object> map) {
        return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templateLocation, ENCODING, map);
    }
}