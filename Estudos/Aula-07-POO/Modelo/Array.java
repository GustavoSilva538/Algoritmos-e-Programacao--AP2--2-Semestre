package Modelo;

public class Array {
    private Produto [] lista = new Produto[4];
    private int controle = 0;

    public void inserir (Produto produto){
        lista[controle++]=produto;
    }

    public void exibir(){
        for (int i = 0; i < controle; i++) {
            System.out.println("Nome: " + lista[i].getNome());
            System.out.println("Marca: " + lista[i].getMarca());
            System.out.println("Preço: " + lista[i].getPreco());
            System.out.println("ID: " + lista[i].getId());
        }

    }

    
}
