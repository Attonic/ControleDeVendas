package com.controleVendas.utils;

import com.controleVendas.entities.Client;
import com.controleVendas.entities.Sale;
import com.controleVendas.entities.Product;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Responsável pelo gerenciamento dos clientes, de vendas e produtos.
 * Registra clientes, produtos e pedidos em listas e permiti exibir essas informações.
 */
public class SaleManager {
    Scanner input = new Scanner(System.in);
    List<Client> clients = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Sale> sales = new ArrayList<>();

    public void registerClient(Client client){
        clients.add(client);
    }

    public void registerProduct(Product product){
        products.add(product);
    }


    //Solicita se quer aplicar o desconto de 5%
    public double applyDiscount(Double totaValue){
        if (totaValue > 100){
            int op;
            while (true){
                System.out.print("Venda acima de R$ 100,00 Deseja aplicar desconto de 5%? 1 = Sim | 2 = Não: ");
                //input.hasNextInt Verifica se a entrada do usuário é um número inteiro. Caso seja, armazena em op.
                if(input.hasNextInt()){
                    op = input.nextInt();
                    if (op == 1){
                        totaValue *= 0.95;
                        System.out.println("Desconto aplicado, novo valor total de: " + totaValue);
                        break;
                    } else if (op == 2){
                        System.out.println("Desconto não aplicado! ");
                        break;
                    }else {
                        System.out.print("Opção invalida, digite 1 para SIM ou 2 para NÂO");
                    }
                }else {
                    System.out.print("Entrada invalida, digite 1 para SIM ou 2 para NÂO");
                    input.next();
                }
            }

        }
     return totaValue;
    }



    /*Realiza a venda armazenando o cliente, produto e quantidade em uma instancia de Sale(Venda) depois adiciona
    essa venda em uma lista de Sales. */
    public void saleRegisterOrders(Client client, Product product, int quantity){
        if(product.getStockQuantity() >= quantity){

            Sale sale = new Sale(client, product, quantity);
            sales.add(sale);
            double finalValue = applyDiscount(sale.getTotalValue());
            sale.setTotalValue(finalValue);
            System.out.println("Venda concluída!");
            product.setStockQuantity(product.getStockQuantity() - quantity);
            System.out.println(sale);
        }else {
            System.out.println("Não há quantidade suficiente no estoque! " + product.getStockQuantity());
        }
    }

    //Exibe todos clientes adicionados na lista.
    public void displayClients(){
        if(clients.isEmpty()){ // Verifica se lista esta vazia
            System.out.println("Lista de clientes vazia!");
        }else{
            //Cria uma formatação de data para converter o localdate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for(Client client : clients){
                String dateFormated = client.getBirthDate().format(formatter);
                System.out.println("Nome: " + client.getName() +
                                    " | Id: " + client.getId() +
                                    " | Data de Nascimento: " + dateFormated);

            }
        }
    }
    //Exibe todos os produtos na lista.
    public void displayProducts(){
        if(products.isEmpty()){
            System.out.println("Não há produtos cadastros! ");
        }else{
            for(Product product : products){
                System.out.println("Produto: " + product.getName() +
                                    " | Id: " + product.getId() +
                                    " | Quantidade em Estoque: " + product.getStockQuantity());
            }
        }
    }
    //Exibe todos as vendas na lista.
    public void displayOrders(){
        if(sales.isEmpty()){
            System.out.println("Não há vendas feitas!");
        }else{
            System.out.println("Lista das Vendas: ");
            for(Sale sale : sales){
                System.out.println(sale); //Usa o toString de sale.
            }
        }
    }

    //Busca vendas de clientes pelo nome
    public List<Sale> searchSalesName(List<Sale> sales, String name){
        List<Sale> salesFound = new ArrayList<>();

        for (Sale sale : sales){
            if(sale.getClient().getName().equalsIgnoreCase(name)){
                salesFound.add(sale);
            }
        }
        return salesFound;
    }

    //Exibe as vendas do cliente usando o metodo searchSalesName.
    public void displaySalesByName(List<Sale> sales, String name){

        /*Esta lista usa encapsulamento para armazenar resultados do metedo searchSaleName
        * passando para ele sales e name*/
        List<Sale> salesFound = searchSalesName(sales, name);

         if (salesFound.isEmpty()){
             System.out.println("Não foi encontrado nenhuma venda para o cliente: " + name);
         }else{
             System.out.println("Vendas encontrada para o cliente: " + name);
             for (Sale sale : salesFound){
                 System.out.println("Produto:  " + sale.getProduct().getName() +
                                    " | Quantidade: " + sale.getQuantity() +
                                    " | Valor Total: " + sale.getTotalValue());
             }
         }

    }
    //Busca o produto dentro da Lista de Produtos (products) e altera o estoque
    public void changeStock(int idProduct, int newQuantity){
        for(Product product : products){
            if (product.getId().equals(idProduct)){
                product.setStockQuantity(newQuantity);
                System.out.println("Estoque do produto: " + product.getName() +
                                    " | Atualizado para: " + product.getStockQuantity());
            }else {
                System.out.println("Produto não encontrado!");
            }
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public Scanner getInput() {
        return input;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
