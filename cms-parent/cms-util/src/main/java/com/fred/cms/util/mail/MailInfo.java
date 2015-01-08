package com.fred.cms.util.mail;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;

public class MailInfo {

    private String from;
    private String to;
    private String content;
    private String subject;

    private String inlineFilePath;
    private String attachmentFilePath;
    private String templateLocation;
    private Map<String, Object> params;

    public static class Builder {

        private String from;
        private String to;
        private String content;
        private String subject;

        private String inlineFilePath;
        private String attachmentFilePath;
        private String templateLocation;
        private Map<String, Object> params;

        public Builder(String from, String to, String content, String subject) {

            this.from = from;
            this.to = to;
            this.content = content;
            this.subject = subject;
        }

        public Builder inlineFilePath(String inlineFilePath) {
            this.inlineFilePath = inlineFilePath;
            return this;
        }

        public Builder attachmentFilePath(String attachmentFilePath) {
            this.attachmentFilePath = attachmentFilePath;
            return this;
        }

        public Builder templateLocation(String templateLocation) {
            this.templateLocation = templateLocation;
            return this;
        }

        public Builder params(Map<String, Object> params) {
            this.params = params;
            return this;
        }

        public MailInfo build() {
            return new MailInfo(this);
        }
    }

    private MailInfo(Builder builder) {

        this.from = builder.from;
        this.to = builder.to;
        this.content = builder.content;
        this.subject = builder.subject;

        this.inlineFilePath = builder.inlineFilePath;
        this.attachmentFilePath = builder.attachmentFilePath;
        this.templateLocation = builder.templateLocation;
        this.params = builder.params;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public String getInlineFilePath() {
        return inlineFilePath;
    }

    public String getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public String getTemplateLocation() {
        return templateLocation;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public static void main(String[] args) {

        Map<String, Object> params = Maps.newHashMap();
        params.put("aaa", "bbb");

        MailInfo mailInfo = new MailInfo.Builder("from", "to", "content", "subject")
                .attachmentFilePath("attachmentFilePath").inlineFilePath("inlineFilePath").params(params).build();

        System.out.println(mailInfo.getFrom());
        System.out.println(mailInfo.getTo());
        System.out.println(mailInfo.getContent());
        System.out.println(mailInfo.getSubject());
        System.out.println("-------------------------");

        System.out.println(mailInfo.getAttachmentFilePath());
        System.out.println(mailInfo.getInlineFilePath());
        Set<Entry<String, Object>> entrySet = mailInfo.getParams().entrySet();

        for (Entry<String, Object> entry : entrySet) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
