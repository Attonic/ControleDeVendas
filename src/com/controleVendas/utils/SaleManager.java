package com.controleVendas.utils;

import com.controleVendas.entities.Client;
import com.controleVendas.entities.Sale;
import com.controleVendas.entities.Product;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Responsável pelo gerenciamento dos clientes, de vendas e produtos.
 * Registra clientes, produtos e pedidos em listas e permiti exibir essas informações.
 */
public class SaleManager {

    List<Client> clients = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Sale> sales = new ArrayList<>();

    public void registerClient(Client client){
        clients.add(client);
    }

    public void registerProduct(Product product){
        products.add(product);
    }

    public void saleRegisterOrders(Client client, Product product, int quantity){
        if(product.getStockQuantity() >= quantity){
            Sale sale = new Sale(client, product, quantity);
            sales.add(sale);
            product.setStockQuantity(product.getStockQuantity() - quantity);
        }else {
            System.out.println("Não há quantidade suficiente no estoque! " + product.getStockQuantity());
        }
    }

    public void displayClients(){
        if(clients.isEmpty()){
            System.out.println("Lista de clientes vazia!");
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for(Client client : clients){
                String dateFormated = client.getBirthDate().format(formatter);
                System.out.println("Nome: " + client.getName() +
                                    " | Id: " + client.getId() +
                                    " | Data de Nascimento: " + dateFormated);

            }
        }
    }
    
    public void displayProducts(){
        if(products.isEmpty()){
            System.out.println("Não há produtos cadastros! ");
        }else{
            for(Product product : products){
                System.out.println("Produto: " + product.getName() +
                                    " | Id: " + product.getId() +
                                    " | Quantidade em Estoque :" + product.getStockQuantity());
            }
        }
    }
    public void displayOrders(){
        if(sales.isEmpty()){
            System.out.println("Não há vendas feitas!");
        }else{
            System.out.println("Lista das Vendas: ");
            for(Sale sale : sales){
                System.out.println(sale);;
            }
        }
    }

}
