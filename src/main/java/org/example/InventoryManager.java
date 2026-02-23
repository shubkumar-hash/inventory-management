package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private List<Supplier> suppliers;
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;
    private List<PurchasedOrder> purchasedOrders;
    private List<Stock> stocks;

    public InventoryManager() {
        suppliers = new ArrayList<>();
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        purchasedOrders = new ArrayList<>();
        stocks = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        if (supplier == null) throw new IllegalArgumentException("Supplier cannot be null");
        suppliers.add(supplier);
    }

    public void addCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        customers.add(customer);
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        products.add(product);
        stocks.add(new Stock(product, 0));
    }

    private Stock getStockByProduct(Product product) {
        for (Stock s : stocks) {
            if (s.getProduct().equals(product)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Stock not found for product: " + product.getProductName());
    }

    public PurchasedOrder createPurchasedOrder(Supplier supplier,
                                               List<PurchasedOrderItem> items,
                                               LocalDate date) {

        PurchasedOrder po = new PurchasedOrder(supplier, items, date);
        purchasedOrders.add(po);

        for (PurchasedOrderItem item : items) {
            Stock stock = getStockByProduct(item.getProduct());
            stock.increaseQuantity(item.getQuantity());
        }

        return po;
    }

    public void showStock() {
        System.out.println("CURRENT STOCK:");
        for (Stock s : stocks) {
            System.out.println(s);
        }
    }

    public Order createOrder(Customer customer, List<OrderItem> items) {

        for (OrderItem item : items) {
            Stock stock = getStockByProduct(item.getProduct());
            if (!stock.isAvailable(item.getQuantity())) {
                throw new IllegalStateException(
                        "Not enough stock for product: " + item.getProduct().getProductName());
            }
        }

        Order order = new Order(customer, items);

        Payment payment = new Payment(order);
        payment.markPaid();

        order.setPayment(payment);

        Delivery delivery = new Delivery(order, LocalDate.now().plusDays(2));
        order.setDelivery(delivery);

        for (OrderItem item : items) {
            Stock stock = getStockByProduct(item.getProduct());
            stock.decreaseQuantity(item.getQuantity());
        }

        orders.add(order);
        return order;
    }

    public void showAllOrders(){
        for(Order order : orders){
            System.out.println(order);
        }
    }
}
