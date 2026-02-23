package org.example;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class PurchasedOrder {

    private static int counter = 0;

    private final int purchasedOrderId;
    private final Supplier supplier;
    private final List<PurchasedOrderItem> items;
    private final LocalDate purchaseDate;
    private final double totalAmount;

    public PurchasedOrder(Supplier supplier, List<PurchasedOrderItem> items, LocalDate purchaseDate) {

        if (supplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Purchased order must contain at least one item");
        }
        if (purchaseDate == null) {
            throw new IllegalArgumentException("Purchase date cannot be null");
        }

        this.purchasedOrderId = ++counter;
        this.supplier = supplier;
        this.items = List.copyOf(items);
        this.purchaseDate = purchaseDate;

        double sum = 0;
        for (PurchasedOrderItem item : items) {
            sum += item.getPurchasePrice();
        }
        this.totalAmount = sum;
    }

    public int getPurchasedOrderId() {
        return purchasedOrderId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<PurchasedOrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

