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

    public boolean alterarPreco(int idAlvo, double novoPreco){
        Produto produto = busca(idAlvo);

        if (produto != null){
            produto.setPreco(novoPreco);
            return true;
        }

        return false;
    }

    public boolean removerPorId (int idAlvo){
        Produto produto = busca(idAlvo);

        for (int i = 0; i < controle; i++) {
            if (lista[i].getId() == idAlvo) {

                lista[i] = lista[controle - 1];
                lista[controle - 1] = null;
                controle--;

                return true;

            }
        }

        return false;

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

    public Produto busca(int idAlvo) {
        for (int i = 0; i < controle ; i++) {
            if (lista[i].getId() == idAlvo){
                return lista[i];
            }
        }
        return null;
    }



}