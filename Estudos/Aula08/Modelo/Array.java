package Modelo;
public class Array {
    private Produto[] lista= new Produto[4];
    private int controle = 0;

    public void inserir(Produto produto){
        if (controle == lista.length){
            lista = alocarNovoArray();
        }
        lista[controle++]= produto;
    }

    private Produto[] alocarNovoArray(){
        Produto[] novo = new Produto[lista.length+1];
        System.arraycopy(lista, 0, novo, 0, lista.length);
        return novo;
    }

    public void exibir(){
        for(int i=0;i<controle;i++){
            System.out.println("ID: "+lista[i].getId());
            System.out.println("Nome: "+lista[i].getNome());
            System.out.println("Marca: "+lista[i].getMarca());
            System.out.println("Preco: "+lista[i].getPreco());
            System.out.println("..................");
        }
    }

}