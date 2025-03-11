package com.controleVendas.main;


import com.controleVendas.entities.Client;
import com.controleVendas.entities.Product;
import com.controleVendas.utils.SaleManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birth = LocalDate.parse("02/04/1997", formatter);

        System.out.println("ola");

        Client client = new Client("Cleison", birth);
        Client loda = new Client("João Loda", LocalDate.of(1992, 4, 3));
        Product cafe = new Product("Cafe", 20, 20.0);
        System.out.println(client.toString());
        System.out.println(loda.toString());

        SaleManager sale = new SaleManager();
        sale.registerClient(client);
        sale.registerClient(loda);
        sale.displayClients();
        System.out.println();
        sale.saleRegisterOrders(client, cafe, 10);
        sale.displayOrders();
        System.out.println();
        sale.saleRegisterOrders(loda, cafe, 10);
        sale.displayOrders();
        System.out.println();
        sale.saleRegisterOrders(client, cafe, 20);
    }
}
