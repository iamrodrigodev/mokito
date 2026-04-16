package com.vogella.junit5;

public class NotificationService {
    private final EmailClient emailClient;
    private final EmailService emailService;
    private EmailStatus lastEmailStatus = new EmailStatus(false);

    public NotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
        this.emailService = null;
    }

    public NotificationService(EmailService emailService) {
        this.emailClient = null;
        this.emailService = emailService;
    }

    public void sendWelcomeEmail(String email) {
        boolean result = emailClient.sendEmail(
                email,
                "Welcome!",
                "Welcome to our platform"
        );
        this.lastEmailStatus = new EmailStatus(result);
    }

    public EmailStatus getLastEmailStatus() {
        return lastEmailStatus;
    }

    public boolean sendNotificationAsync(String email, String content) {
        final boolean[] ok = {false};
        emailService.sendEmailAsync(email, content, new Callback() {
            @Override
            public void onSuccess(String message) {
                ok[0] = true;
            }

            @Override
            public void onFailure(String error) {
                ok[0] = false;
            }
        });
        return ok[0];
    }
}

