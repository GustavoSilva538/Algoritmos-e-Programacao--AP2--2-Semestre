import java.util.Random;
import java.util.Scanner;

public class ExemploBusca2 {
    public static void ordenar(int [] vetor) {

            int temp;

            for (int j = 0; j < vetor.length - 1; j++) {
                int menor = j;
                for(int i = j + 1; i < vetor.length; i++){
                    if( vetor[menor] > vetor[i]){
                        menor=i;
                    }
                }

                temp=vetor[menor];
                vetor[menor]=vetor[j];
                vetor[j]=temp;
            }

    }


    public static void inserirValores(int [] vetor) {
        Random rd = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(1, 501);
        }
    }

    public static void exibir(int [] vetor) {
        int i = 0;
        for (int numero : vetor){
            System.out.println(numero + "  +" + i++);
        }
    }

    public static int busca(int [] vetor, int alvo) {
        int inicio = 0;
        int meio;
        int fim = vetor.length -1;

        while (inicio <= fim) {

            meio = (fim + inicio) / 2;

            if (alvo == vetor[meio]) {
                return meio;
            } else if (alvo > vetor[meio]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }

        }
    return -1;
    }

    public static void main(String[] args) {
        Scanner bob = new Scanner(System.in);

        int [] vetor = new int [100];

        inserirValores(vetor);
        ordenar(vetor);
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
