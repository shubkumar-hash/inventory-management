package org.example;

import java.time.LocalDateTime;

public class Payment {

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED
    }

    private static int counter = 0;

    private final int paymentId;
    private final int orderId;
    private final double amount;
    private PaymentStatus status;
    private final LocalDateTime paymentTime;

    public Payment(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        this.paymentId = ++counter;
        this.orderId = order.getOrderId();
        this.amount = order.getTotalAmount();
        this.status = PaymentStatus.PENDING;
        this.paymentTime = LocalDateTime.now();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void markPaid() {
        this.status = PaymentStatus.COMPLETED;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

}


