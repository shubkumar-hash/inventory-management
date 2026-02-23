package org.example;

public class OrderItem {
    private final Product product;
    private final int quantity;
    private final double price;
    public OrderItem(Product product, int quantity) {
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Enter a valid quantity");
        }
        this.product = product;
        this.quantity = quantity;
        this.price = this.product.getSellingPrice() * quantity;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "OrderItem [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
    }

}
