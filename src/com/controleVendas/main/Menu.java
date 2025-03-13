package com.controleVendas.main;


import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int op;
        do {
            System.out.println("------- Controle de Vendas ------");
            System.out.println();
            System.out.println("---  1 - Cadastrar Cliente: -----");
            System.out.println("---  2 - Cadastrar Produto: -----");
            System.out.println("---  3 - Consultar Cliente: -----");
            System.out.println("---  4 - Consultar Produto: -----");
            System.out.println("---  5 - Vender: ");
            System.out.println("---  6 - Consultar Vendas:  -----");
            System.out.println("---  7 - Alterar Estoque:   -----");
            System.out.println("---  8 - Consultar por nome Cliente: ");
            System.out.println("---  9 - Sair:  -----");
            System.out.print("---- Selecione uma opção: ");
            op = input.nextInt();

            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    op = 9;
                    break;
            }

        }while (op != 9);





    }
}
