import java.util.Scanner;

public class Main {

    public static void exibir(String [] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ,");
        }
    }


    private static int particao(int e, int d, String[] a) {
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


    public static void tipoDeOrdenacao (int num, String[] lista){
        switch (num){
            case 1:
                System.out.println("Desordenado: ");
                exibir(lista);
                System.out.println("");
                System.out.println("Ordenado: ");
                quickSort(0, lista.length - 1, lista);
                exibir(lista);
            break;



            case 2:

            break;
        }

    }

    


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] lista = {"Uva", "abacaxi", "Pêra", "manga", "Caju", "maçã",
                "Laranja", "banana", "Kiwi", "limão", "Abacate", "goiaba",
                "Morango", "acerola", "Pitaya", "caqui", "Jabuticaba",
                "amora", "Framboesa", "cereja"};


        System.out.println("====== MENU ======");
        System.out.println("Digite qual Método de Ordenação você deseja utilizar: ");
        System.out.println("1 -Quick Sort");
        System.out.println("2 -Merge Sort");
        int num = sc.nextInt();
        tipoDeOrdenacao(num, lista);

    }
}
