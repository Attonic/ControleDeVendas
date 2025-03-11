package com.controleVendas.utils;

public abstract class AbstractRegister {
    private static Integer ID = 1;
    private String name;
    private Integer id;

    public AbstractRegister(String name) {
        this.name = name;
        this.id = ID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }




}
