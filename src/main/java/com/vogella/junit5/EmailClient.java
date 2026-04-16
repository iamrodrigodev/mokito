package com.vogella.junit5;

public interface EmailClient {
    boolean sendEmail(String to, String subject, String body);
}

