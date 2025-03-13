package com.controleVendas.main;


import com.controleVendas.entities.Client;
import com.controleVendas.entities.Product;
import com.controleVendas.utils.SaleManager;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SaleManager saleManager = new SaleManager();

        int op;
        do {
            System.out.println("\n------- Controle de Vendas --------");
            System.out.println();
            System.out.println("---  1 - Cadastrar Cliente: ---------");
            System.out.println("---  2 - Cadastrar Produto: ---------");
            System.out.println("---  3 - Consultar Cliente: ---------");
            System.out.println("---  4 - Consultar Produto: ---------");
            System.out.println("---  5 - Vender: --------------------");
            System.out.println("---  6 - Consultar Vendas: ----------");
            System.out.println("---  7 - Alterar Estoque:  ----------");
            System.out.println("---  8 - Consultar por nome Cliente: ");
            System.out.println("---  9 - Sair:  ---------------------");
            System.out.print("---- Selecione uma opção: ");
            op = input.nextInt();
            input.nextLine();

            switch(op){

                case 1:  //Cadastrar Clientes
                    registerCliente(input, saleManager);
                    break;
                case 2: // Cadastrar Produto
                    break;
                case 3: // Consultar Cliente
                    saleManager.displayClients();
                    break;
                case 4: // Consultar Produto
                    saleManager.displayProducts();
                    break;
                case 5: //  Vender

                    break;
                case 6: //  Consultar Vendas
                    saleManager.displayOrders();
                    break;
                case 7: //   Alterar Estoque
                    break;

                case 8:  //   Consultar por nome Cliente
                    break;
                case 9: //    Sair
                    op = 9;
                    break;
            }

        }while (op != 9);





    }

    private static void registerCliente(Scanner input, SaleManager saleManager){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Digite o nome Cliente: ");
        String name = input.nextLine();

        LocalDate birthDate = null;

        while (true){
            System.out.print("Digite a data de Nascimento do cliente: ");
            try {
                birthDate = LocalDate.parse(input.nextLine(), formatter);
                break;
            }catch (DateTimeException e){
                System.out.println("A data é invalida, use o formato: dd/MM/yyyy ");
            }
        }

        Client client = new Client(name, birthDate);
        saleManager.registerClient(client);
        System.out.println("Cliente Cadastrado!");
        System.out.println(client);
    }
}
