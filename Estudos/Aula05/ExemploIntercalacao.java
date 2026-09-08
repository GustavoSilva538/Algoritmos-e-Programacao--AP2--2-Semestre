import java.util.Arrays;

public class ExemploIntercalacao {

    public static void intercalar(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compara os elementos dos dois arrays
        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }

            k++;
        }

        // Sobraram elementos em a
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        // Sobraram elementos em b
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(c));
    }

    public static void main(String[] args) {

        int[] a = {2, 4, 7, 9, 11, 16, 18};
        int[] b = {3, 10, 12, 22, 34};

        intercalar(a, b);
    }
}