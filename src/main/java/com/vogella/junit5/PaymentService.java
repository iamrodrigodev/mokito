package com.vogella.junit5;

public class PaymentService {
    private final PaymentGateway paymentGateway;
    private final AuditService auditService;

    public PaymentService(PaymentGateway paymentGateway, AuditService auditService) {
        this.paymentGateway = paymentGateway;
        this.auditService = auditService;
    }

    public PaymentResult processPayment(double amount, String cardNumber) {
        PaymentResult result = paymentGateway.processPayment(amount, cardNumber);
        if (result.isSuccess()) {
            auditService.logPayment(amount, result.getTransactionId());
        } else {
            auditService.logPaymentFailure(amount, result.getTransactionId());
        }
        return result;
    }
}

