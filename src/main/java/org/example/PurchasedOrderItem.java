package org.example;

public class PurchasedOrderItem {

    private final Product product;
    private final int quantity;
    private final double purchasePrice;

    public PurchasedOrderItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.product = product;
        this.quantity = quantity;
        this.purchasePrice = product.getPurchasedPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
}

