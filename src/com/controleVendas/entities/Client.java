package com.controleVendas.entities;

import com.controleVendas.utils.AbstractRegister;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client extends AbstractRegister {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate birthDate;


    public Client(String name, LocalDate birthDate) {
        super(name);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "nome: " + getName()  +
                " | Código: " + getId() +
                " | Data de Aniversário: " + (birthDate != null  ? dtf.format(birthDate) : "Sem data");
    }
}
