package com.controleVendas.entities;

public class Product {
    private static Integer ID = 1;
    private String name;
    private Integer stockQuantity;
    private Double price;
    private Integer id;

    public Product(String name, Integer stockQuantity, Double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.id = ID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto: " +
                "nome: " + getName()  +
                " | Código: " + getId() +
                " | Preço: " + getPrice() +
                " | Quantidade: " + getStockQuantity();
    }
}
