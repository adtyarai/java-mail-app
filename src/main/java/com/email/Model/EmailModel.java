package com.email.Model;

public class EmailModel {
    private String to;
    private String message;
    private String subject;

    public EmailModel (String to, String message, String subject) {
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    public EmailModel () {
    }

    public String getTo () {
        return to;
    }

    public void setTo (String to) {
        this.to = to;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getSubject () {
        return subject;
    }

    public void setSubject (String subject) {
        this.subject = subject;
    }

    @Override
    public String toString () {
        return "EmailModel{" +
                "to='" + to + '\'' +
                ", message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
