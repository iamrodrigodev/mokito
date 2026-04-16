package com.vogella.junit5;

public class EmailStatus {
    private final boolean success;

    public EmailStatus(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}

