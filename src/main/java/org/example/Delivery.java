package org.example;

import java.time.LocalDate;

public class Delivery {

    public enum DeliveryStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    private static int counter = 0;

    private final int deliveryId;
    private final int orderId;
    private LocalDate deliveryDate;
    private DeliveryStatus status;

    public Delivery(Order order, LocalDate deliveryDate) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (deliveryDate == null) {
            throw new IllegalArgumentException("Delivery date cannot be null");
        }

        this.deliveryId = ++counter;
        this.orderId = order.getOrderId();
        this.deliveryDate = deliveryDate;
        this.status = DeliveryStatus.PENDING;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void markShipped() {
        this.status = DeliveryStatus.SHIPPED;
    }

    public void markDelivered() {
        this.status = DeliveryStatus.DELIVERED;
    }

    public void cancelDelivery() {
        this.status = DeliveryStatus.CANCELLED;
    }
}

