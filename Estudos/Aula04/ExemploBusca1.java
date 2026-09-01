import java.util.Random;
import java.util.Scanner;

public class ExemploBusca1 {
    public static void inserirValores(int [] vetor) {
        Random rd = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(1, 501);
        }
    }

    public static void exibir(int [] vetor) {
        for (int numero : vetor){
            System.out.println(numero);
        }
    }

    public static int busca(int [] vetor, int alvo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == alvo){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner bob = new Scanner(System.in);

        int [] vetor = new int [100];

        inserirValores(vetor);
        exibir(vetor);
        System.out.println("DIgite o valor que você deseja encontrar: ");
        int alvo = bob.nextInt();
        bob.close();
        int resultado = busca(vetor, alvo);

        if (resultado != -1){
            System.out.println("O valor é: " + resultado);
        }else{
            System.out.println("Valor não encontrado");
        }

    }
}
