package Atividade02;

public class Exercicio02 {


    public static void exibir(String [] vetor) {
         for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
         }
    }


    public static void mergeSort(int inicio, int tamanho, String[] vetor) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSort(inicio, meio, vetor);
            mergeSort(meio, tamanho, vetor);
            intercalar(inicio, meio, tamanho, vetor);
        }
    }

    private static void intercalar(int inicio, int meio, int tamanho, String[] v) {
        int i, j, k;
        String[] auxiliar = new String[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;
        while (i < meio && j < tamanho) {
            if (v[i].compareToIgnoreCase(v[j]) <= 0) {
                auxiliar[k] = v[i];
                k++;
                i++;
            } else {
                auxiliar[k] = v[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            auxiliar[k] = v[i];
            k++;
            i++;
        }

        while (j < tamanho) {
            auxiliar[k] = v[j];
            k++;
            j++;
        }

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }


    public static void main(String[] args) {
        String [] vetor = {"ana", "Bruno", "carla", "Diego", "eduarda", "Felipe", "gabriela", "Henrique", "isabela", "João"};
        System.out.println("Desordenado: ");
        exibir(vetor);
        mergeSort(0, vetor.length, vetor);
        System.out.println("Ordenado: " );
        exibir(vetor);




    }
}
