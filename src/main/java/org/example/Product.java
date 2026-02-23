package org.example;

import java.time.LocalDate;

public class Product {
    private static int counter = 0;
    private final int productId;
    private String productName;
    private String companyName;
    private double sellingPrice;
    private double purchasedPrice;
    private LocalDate expDate;
    public Product(String productName, String companyName, double sellingPrice, double purchasedPrice,
                   LocalDate expDate) {
        this.productId = ++counter;
        this.productName = productName;
        this.companyName = companyName;
        this.sellingPrice = sellingPrice;
        this.purchasedPrice = purchasedPrice;
        if (expDate == null) {
            this.expDate = LocalDate.of(9999, 12, 31);
        } else {
            this.expDate = expDate;
        }
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public double getPurchasedPrice() {
        return purchasedPrice;
    }
    public LocalDate getExpDate() {
        return expDate;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", companyName=" + companyName
                + ", sellingPrice=" + sellingPrice + ", purchasedPrice=" + purchasedPrice + ", expDate=" + expDate
                + "]";
    }

    public boolean isExpired(){
        return LocalDate.now().isAfter(this.expDate);
    }

}

