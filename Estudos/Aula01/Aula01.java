import java.util.Random;
public class Aula01 {

    public static void main(String[] args) {
        int [] v = new int[10];
        aleatorio(v);
        ordenar(v);
        mostrar(v);

    }


    public static void aleatorio(int [] a){
        Random rd = new Random();

        for (int i = 0; i < a.length ; i++) {
            a[i] = rd.nextInt(101);
        }
    }


    public static void mostrar(int [] b){
        for (int valor : b) {
            System.out.println(valor);
        }
    }

    public static void ordenar(int [] b){
        int temp;
        for (int j = 0; j < b.length-1; j++) {
            for (int i = 0; i < b.length - 1 - j ; i++) {
                if (b[i] > b [i+1]){
                    temp = b[i];
                    b[i] = b [i+1];
                    b[i+1] = temp;
                }
            }
        }


    }



}