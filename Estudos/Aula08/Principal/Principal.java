package Principal;

import Modelo.Array;
import Modelo.Produto;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = 0;
        Array produtos =new Array();
        Produto p1= new  Produto("LG", "TV", 1200, 1);
        Produto p2=new Produto("Apple", "Iphone", 13000, 2);
        Produto p3=new Produto("Sansumg", "Smartphone", 1500, 3);
        Produto p4=new Produto("Motorola", "Smartphone", 2000, 4);
        Produto p5=new Produto("Xiaomi", "Smartphone", 4000, 5);

        produtos.inserir(p1);
        produtos.inserir(p2);
        produtos.inserir(p3);
        produtos.inserir(p4);
        produtos.inserir(p5);



        while(loop == 0){
            System.out.println("====== Menu ======");
            System.out.println("1) Buscar Produto por ID");
            System.out.println("2) Atualizar Produto por ID");
            System.out.println("3) Remover por ID");
            System.out.println("4) Exibir todos os produtos");
            System.out.println("5) Sair");

            int escolha = sc.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Digite o ID do produto que você deseja buscar: ");
                    int idAlvo = sc.nextInt();

                    Produto resultadoBusca = produtos.busca(idAlvo);
                    if (resultadoBusca != null){
                        System.out.println("Produto encontrado: " + resultadoBusca);
                    }else {
                        System.out.println("Produto com o ID " + idAlvo + " não encontrado");
                    }
                    break;

                case 2:
                    System.out.println("Digite o número do ID em que você deseja atualizar o preço: ");
                    idAlvo = sc.nextInt();
                    System.out.println("Digite o novo valor do Produto: ");
                    double novoPreco = sc.nextDouble();

                    boolean alterado = produtos.alterarPreco(idAlvo, novoPreco);

                    if (alterado){
                        System.out.println("Valor alterado");
                    }else{
                        System.out.println("valor não encontrado para alterar o preço");
                    }

                    resultadoBusca = produtos.busca(idAlvo);
                    System.out.println("Valor ja alterado: " + resultadoBusca);
                    break;


                case 3:
                    System.out.println("Digite o ID do produto em que você deseja remover: ");
                    idAlvo = sc.nextInt();

                    boolean valorRemovido = produtos.removerPorId(idAlvo);

                    if (valorRemovido){
                        System.out.println("Produto Removido");
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 4:
                    produtos.exibir();
                    break;

                case 5:
                    loop = 1;
                    break;


                default:
                    System.out.println("Valor Inválido");

            }
        }

        sc.close();

    }
}