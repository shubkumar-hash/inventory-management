package org.example;

public class Stock {

    private final Product product;
    private int quantity;

    public Stock(Product product, int initialQuantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (initialQuantity < 0) {
            throw new IllegalArgumentException("Initial quantity cannot be negative");
        }
        this.product = product;
        this.quantity = initialQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }

    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Increase amount must be positive");
        }
        quantity += amount;
    }

    public void decreaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Decrease amount must be positive");
        }
        if (amount > quantity) {
            throw new IllegalStateException("Not enough stock available");
        }
        quantity -= amount;
    }

    @Override
    public String toString() {
        return "Stock [product=" + product.getProductName() +
                ", quantity=" + quantity + "]";
    }
}

