package Atividade02;

import java.util.Random;

    public class Exercicio01 {
        public static void inserirValores(long[] vetor) {
            Random rd = new Random();
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = rd.nextLong(100,10000);
            }
        }

    public static void exibir(long[] vetor) {
        int i = 0;
        for (int j = 0; j <= 20; j++) {
            System.out.println(vetor[j]);
        }
    }

    private static void intercalar(int inicio, int meio, int tamanho, long[] v) {
        int i, j, k;
        long[] auxiliar = new long[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;
        while (i < meio && j < tamanho) {
            if (v[i] <= v[j]) {
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

    public static void mergeSort(int inicio, int tamanho, long[] vetor) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSort(inicio, meio, vetor);
            mergeSort(meio, tamanho, vetor);
            intercalar(inicio, meio, tamanho, vetor);
        }
    }


    public static void main(String[] args) {
        long[] vetor = new long[1000];
        inserirValores(vetor);
        mergeSort(0, vetor.length, vetor);
        exibir(vetor);


    }
}
