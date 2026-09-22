import java.util.Random;
public class QuickSort {
    public static void aleatorio (int [] v){
        Random rd = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rd.nextInt(1, 1001);
        }
    }
    public static void exibir (int v[]){
        for (int n : v){
            System.out.print(n + ", ");
        }
    }
    private static int particao(int e, int d,int[] a) {
        int pivo, aux;
        int i, j;
        pivo = a[d];
        i = e - 1;
        j = d;
        do {
            do {
                i = i + 1;
            } while ((a[i] < pivo) && (i < d));
            do {
                j = j - 1;
            } while ((a[j] > pivo) && (j > 0));
            aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        } while (j > i);
        a[j] = a[i];
        a[i] = a[d];
        a[d] = aux;
        return i;
    }
    public static void quickSort(int e, int d, int[] a) {
        int i;
        if (d > e) {
            i = particao(e,d,a);
            quickSort(e, i - 1,a);
            quickSort(i + 1, d,a);
        }
    }
    public static void main(String[] args) {
        int v [] = new int[100];
        aleatorio(v);
        System.out.println("Desordenado: ");
        exibir(v);
        quickSort(0, v.length - 1, v);
        System.out.println("\nOrdenado: ");
        exibir(v);
    }
}