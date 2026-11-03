package Principal;
import Modelo.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Array produtos = new Array();

        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        Produto p4 = new Produto();

        produtos.inserir(p1);
        produtos.inserir(p2);
        produtos.inserir(p3);
        produtos.inserir(p4);


        int loop = 0;


        while(loop == 0){

            System.out.println("====== MENU ======");
            System.out.println("1) Atualizar Lista");
            System.out.println("2) Imprimir Lista");
            System.out.println("3) Sair");
            int escolha = sc.nextInt();


            switch (escolha) {
                case 1:
                    System.out.println("Setar Nome: ");
                    String nome = sc.next();
                    p1.setNome(nome);
                    System.out.println("Setar Marca: ");
                    String marca = sc.next();
                    p1.setMarca(marca);
                    System.out.println("Setar ID: ");
                    int id = sc.nextInt();
                    p1.setId(id);
                    System.out.println("Setar Preço: ");
                    double preco = sc.nextDouble();
                    p1.setPreco(preco);
                    break;

                case 2:
                    produtos.exibir();
                    p1.imprimir();
                    break;

                case 3:
                    loop = 1;
                    break;

                default:
                    System.out.println("Digite um valor válido!");
                    break;
            }

        }



    }
}