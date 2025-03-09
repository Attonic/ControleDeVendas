package com.controleVendas.entities;

public class Order {
    private Product product;
    private Client client;
    private Integer quantity;
    private double totalValue;

    public Order(Client client, Product product, Integer quantity, double totalValue) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.totalValue = product.getPrice() * quantity;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public double getTotalValue() {
        return totalValue;
    }


}
