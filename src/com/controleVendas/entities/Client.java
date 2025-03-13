package com.controleVendas.entities;

import com.controleVendas.utils.AbstractRegister;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client extends AbstractRegister {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Integer ID = 1;
    private LocalDate birthDate;
    private Integer id;

    public Client(String name, LocalDate birthDate) {
        super(name);
        this.birthDate = birthDate;
        this.id = ID++;
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
