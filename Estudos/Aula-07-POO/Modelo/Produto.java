package Modelo;

public class Produto {
    private String nome, marca;
    private double preco;
    private int id;

    public Produto(String nome, String marca, double preco, int id) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.id = id;
    }


    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void imprimir(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: " + this.preco);
    }

}
