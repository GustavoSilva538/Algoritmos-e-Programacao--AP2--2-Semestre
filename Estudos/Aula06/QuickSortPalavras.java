public class QuickSortPalavras {

    public static void exibir(String [] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }

    private static int particao(int e, int d,String[] a) {
        String pivo, aux;
        int i, j;
        pivo = a[d];
        i = e - 1;
        j = d;
        do {
            do {
                i = i + 1;
            } while ((a[i].compareTo(pivo) < 0) && (i < d));
            do {
                j = j - 1;
            } while ((a[j].compareTo(pivo) > 0) && (j > e));
            aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        } while (j > i);
        a[j] = a[i];
        a[i] = a[d];
        a[d] = aux;
        return i;
    }

    public static void quickSort(int e, int d, String[] a) {
        int i;
        if (d > e) {
            i = particao(e,d,a);
            quickSort(e, i - 1,a);
            quickSort(i + 1, d,a);
        }
    }

    public static void main(String[] args) {
        String palavras [] = {"Gustavo", "Abacate", "Maça", "Banana", "Teclado", "Mouse", "Monitor"};
        System.out.println("Desordenado: ");
        exibir(palavras);
        System.out.println("Ordenado: ");
        quickSort(0, palavras.length - 1, palavras);
        exibir(palavras);
    }
}
