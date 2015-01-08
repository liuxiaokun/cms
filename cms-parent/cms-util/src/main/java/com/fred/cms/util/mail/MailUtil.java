/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 7, 2015 4:00:51 PM
 */
package com.fred.cms.util.mail;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
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

    /**
     * Send a simple text email.
     * 
     * @param to
     * @param subject
     * @param mailContent
     */
    public void sendSimpleEmail(String to, String subject, String mailContent) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setFrom("fred_test@163.com");
        mail.setSubject(subject);
        mail.setText(mailContent);
        mailSender.send(mail);
    }

    /**
     * Send a html text email.
     * 
     * @param to
     * @param subject
     * @param htmlContent
     */
    public void sendHtmlEmail(String to, String subject, String htmlContent, String inlineFilePath) {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(message, true, ENCODING);
            helper.setTo(to);
            helper.setFrom("liuxiaokun0410@qq.com");
            helper.setSubject(subject);
            // this true indicate it is a html mail.
            helper.setText(htmlContent, true);

            if (StringUtils.isNotBlank(inlineFilePath)) {
                ClassPathResource inlineFile = new ClassPathResource(inlineFilePath);
                String filename = inlineFile.getFilename();
                helper.addInline(filename.substring(0, filename.lastIndexOf(".")), inlineFile);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    /**
     * send a email with a attachment.
     * 
     * @param to
     * @param content
     * @param subject
     * @param filePath
     *            the path relative to class path.
     */
    public void sendAttachemetnEmail(String to, String content, String subject, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            // use the true flag to indicate you need a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true, ENCODING);

            helper.setTo(to);
            helper.setFrom("liuxiaokun0410@qq.com");
            helper.setText(content, true);
            helper.setSubject(subject);
            ClassPathResource attachment = new ClassPathResource(filePath);
            helper.addAttachment(MimeUtility.encodeWord(attachment.getFilename()), attachment.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    public void sendTemplatedHtmlEmail(String email, String subject, String inlineFilePath, String templateLocation,
            Map<String, Object> map) {

        String content = generateEmailContent(templateLocation, map);
        sendHtmlEmail(email, subject, content, inlineFilePath);
    }

    // generate email content.
    private String generateEmailContent(String templateLocation, Map<String, Object> map) {
        return VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, templateLocation, ENCODING, map);
    }
}
