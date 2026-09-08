import java.util.Scanner;

public class fatorial {

    public static long calcularFatorial(long numero) {


        if (numero <= 1){
            return 1;
        }
        return numero * calcularFatorial(numero - 1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long resultado;

        System.out.println("Digite um número em que deseja saber o fatorial dele: ");
        long numero = sc.nextInt();
        resultado = calcularFatorial(numero);

        System.out.println("O número " + numero + " fatorial é: " + resultado);

        sc.close();
    }
}
