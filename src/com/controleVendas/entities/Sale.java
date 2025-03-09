package com.controleVendas.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private Client client;
    List<Client> clients = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    public void registerClient(String name, Integer id, LocalDate birthDay){
        clients.add(new Client(name, id, birthDay));
    }

    public void registerProduct(String name, Integer id, Integer stockQuantity, Double price){
        products.add(new Product(name, id, stockQuantity, price));
    }

    public void displayClients(){
        if(clients.isEmpty()){
            System.out.println("Lista de clientes vazia!");
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for(Client client : clients){
                String dateFormated = client.getBirthDate().format(formatter);
                System.out.println("Nome: " + client.getName() +
                                    "Id: " + client.getId() +
                                    "Data de Nascimento: " + dateFormated);

            }
        }
    }
    
    public void displayProducts(){
        if(products.isEmpty()){
            System.out.println("Não há produtos cadastros! ");
        }else{
            for(Product product : products){
                System.out.println("Produto: " + product.getName() +
                                    "Id: " + product.getId() +
                                    "Quantidade em Estoque :" + product.getStockQuantity());
            }
        }
    }

}
