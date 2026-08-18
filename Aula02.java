///Exemplo Matriz///
import java.util.Random;
public class Aula02 {

    public static void entrada(int [][] m) {
        Random rd = new Random();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = rd.nextInt(10, 91);
            }
        }
    }

    public static void exibir(int [][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static int somaTotal(int [][] m){
        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                soma += m[i][j];
            }
        }
        return soma;
    }

    public static int somaDiagonalPrin(int [][] m){
        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++, i++) {
                soma += m[i][j];
            }
        }
        return soma;
    }

    public static int somaDiagonalSecun(int [][] m){
        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if ( i + j == m.length - 1){
                    soma += m[i][j];
                }
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
        entrada(matriz);
        exibir(matriz);
        System.out.println(somaTotal(matriz));
        System.out.println(somaDiagonalPrin(matriz));
        System.out.println(somaDiagonalSecun(matriz));
    }
}


