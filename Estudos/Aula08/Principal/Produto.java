package Modelo;

public class Produto {
    private String marca, nome;
    private double preco;
    private int id;

    public Produto(String marca, String nome, double preco, int id) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.preco = preco;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


    public String toString() {
        return "Marca='" + marca + '\'' + ", Nome='" + nome + '\'' + ", preco=" + preco + ", id=" + id ;
    }
}
