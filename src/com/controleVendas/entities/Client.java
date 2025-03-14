package com.controleVendas.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String name;
    private static Integer ID = 1;
    private LocalDate birthDate;
    private Integer id;

    public Client(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.id = ID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "nome: " + getName()  +
                " | Código: " + getId() +
                " | Data de Aniversário: " + (birthDate != null  ? dtf.format(birthDate) : "Sem data");
    }
}
