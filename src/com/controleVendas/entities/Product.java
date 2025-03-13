package com.controleVendas.entities;

import com.controleVendas.utils.AbstractRegister;

public class Product extends AbstractRegister {
    private Integer stockQuantity;
    private Double price;

    public Product(String name, Integer stockQuantity, Double price) {
        super(name);
        this.stockQuantity = stockQuantity;
        this.price = price;
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

    @Override
    public String toString() {
        return "Produto: " +
                "nome: " + getName()  +
                " | Código: " + getId() +
                " | Preço: " + getPrice() +
                " | Quantidade: " + getStockQuantity();
    }
}
