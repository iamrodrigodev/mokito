package com.vogella.junit5;

public interface PaymentGateway {
    PaymentResult processPayment(double amount, String cardNumber);
}

