package org.example;

import java.util.Collections;
import java.util.List;

public class Order {

    private static int counter = 0;

    private final int orderId;
    private final Customer customer;
    private final List<OrderItem> orderItems;
    private Payment payment;
    private Delivery delivery;
    private final double totalAmount;

    public Order(Customer customer, List<OrderItem> orderItems) {

        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        if (orderItems == null || orderItems.isEmpty())
            throw new IllegalArgumentException("Order must contain at least one OrderItem");

        this.orderId = ++counter;
        this.customer = customer;
        this.orderItems = List.copyOf(orderItems);

        double sum = 0;
        for (OrderItem item : orderItems) {
            sum += item.getPrice();
        }
        this.totalAmount = sum;
    }

    public void setPayment(Payment payment) {
        if (payment == null) throw new IllegalArgumentException("Payment cannot be null");
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        if (delivery == null) throw new IllegalArgumentException("Delivery cannot be null");
        this.delivery = delivery;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public Payment getPayment() {
        return payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customer=" + customer + ", orderItems=" + orderItems + ", payment="
                + payment + ", delivery=" + delivery + ", totalAmount=" + totalAmount + "]";
    }


}

