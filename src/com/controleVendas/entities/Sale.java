package com.controleVendas.entities;

public class Sale {
    private Product product;
    private Client client;
    private Integer quantity;
    private double totalValue;

    public Sale(Client client, Product product, Integer quantity) {
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

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    @Override
    public String toString() {
        return "Venda = " + client +
                " | Produto: " + product.getName() +
                " | Quantidade: " + quantity +
                " | Valor Total: " + totalValue;
    }
}
