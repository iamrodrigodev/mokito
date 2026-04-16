package com.vogella.junit5;

import java.util.List;

public interface EmailService {
    boolean sendWelcomeEmail(String email, String name);

    boolean sendVerificationEmail(String email, String verificationCode);

    void sendEmailAsync(String email, String content, Callback callback);

    void sendBulkEmail(List<String> emails, String content);
}

