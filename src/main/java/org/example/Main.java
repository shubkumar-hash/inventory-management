package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Supplier supplier1 = new Supplier("Blinkit", "4524", "Ranchi", "9876789876");
        Supplier supplier2 = new Supplier("BigBasket", "674859", "Bangalore", "8345389876");
        Supplier supplier3 = new Supplier("Zepto", "6786", "Hyderabad", "6487587929");

        Product product1 = new Product("Mobile", "Samsung", 75000, 50000, null);
        Product product2 = new Product("Biscuit", "Parle", 75000, 50000, LocalDate.of(2028, 12, 5));
        Product product3 = new Product("Dolo", "Cipla", 75000, 50000, LocalDate.of(2027, 1, 5));

        Customer customer1 = new Customer("Raj", "9546543456", "raj@gmail.com", "Dehradun");
        Customer customer2 = new Customer("Aman", "7654543456", "aman@gmail.com", "Ranhi");
        Customer customer3 = new Customer("Kiran", "8923443456", "kiran@gmail.com", "Patna");

        manager.addCustomer(customer1);
        manager.addCustomer(customer2);
        manager.addCustomer(customer3);

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

        manager.addSupplier(supplier1);
        manager.addSupplier(supplier2);
        manager.addSupplier(supplier3);

        List<PurchasedOrderItem> purchaseItems = new ArrayList<>();
        purchaseItems.add(new PurchasedOrderItem(product1, 5));
        purchaseItems.add(new PurchasedOrderItem(product2, 50));

        manager.createPurchasedOrder(supplier1, purchaseItems, LocalDate.now());

        manager.showStock();

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(product1, 1));
        orderItems.add(new OrderItem(product2, 10));

        manager.createOrder(customer1, orderItems);

        manager.showStock();
        manager.showAllOrders();
    }
}

