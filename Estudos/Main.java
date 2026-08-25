import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void aleatorio(double [] v) {
        Random rd = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rd.nextDouble(1, 1001);
        }
    }


        public static void selectionSort(double[] v) {
            double temp;
            for (int j = 0; j < v.length - 1; j++) { //Varreduras
                int menor=j;//índice
                for(int i=j+1;i<v.length;i++){//Comparações
                    if(v[menor]>v[i]){
                        menor=i;
                    }
                }
                //Troca
                temp=v[menor];
                v[menor]=v[j];
                v[j]=temp;
            }
        }

        public static void exibir(double[] v){
            for (double n : v){
                System.out.printf("%.3f", n);
            }
            System.out.println(" ");
        }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double v []= new double[20];
        aleatorio(v);
        System.out.println("Desordenado:");
        exibir(v);
        System.out.println("Desordenado: ");
        selectionSort(v);
        exibir(v);

    }
}