package com.fred.cms.util.mail;

import java.util.Map;

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
}
