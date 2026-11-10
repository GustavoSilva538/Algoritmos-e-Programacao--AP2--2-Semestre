package Principal;

import Modelo.Array;
import Modelo.Produto;
public class Principal {
    public static void main(String[] args) {
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
        

        produtos.toString();

    }
}