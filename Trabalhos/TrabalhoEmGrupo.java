import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] frutas = { "Uva", "abacaxi", "Pêra", "manga", "Caju", "maçã",
                "Laranja", "banana", "Kiwi", "limão", "Abacate", "goiaba",
                "Morango", "acerola", "Pitaya", "caqui", "Jabuticaba",
                "amora", "Framboesa", "cereja" };

        while (true) {
            System.out.println("\n================ MENU CONSOLIDADO ================");
            System.out.println("Qual Vetor você deseja utilizar?");
            System.out.println("1- Lista de frutas (Strings)");
            System.out.println("2- Lista de números aleatórios (Inteiros)");
            
            // Valida entrada do tipo de array
            int escolhaArray = lerOpcaoValida(scanner, 1, 2);
            if (escolhaArray == -1) continue;

            System.out.println("\nQual método de ordenação deseja utilizar?");
            System.out.println("1- QuickSort");
            System.out.println("2- MergeSort");
            
            // Valida entrada do algoritmo
            int escolhaAlgoritmo = lerOpcaoValida(scanner, 1, 2);
            if (escolhaAlgoritmo == -1) continue;

            if (escolhaArray == 1) {

                String[] frutasTrabalho = frutas.clone();

                System.out.println("\n--- Lista Desordenada de Frutas ---");
                exibirString(frutasTrabalho);

                if (escolhaAlgoritmo == 1) {
                    quickSortString(0, frutasTrabalho.length - 1, frutasTrabalho);
                    System.out.println("\n--- Lista Ordenada via QuickSort ---");
                } else {
                    mergeSortStr(0, frutasTrabalho.length, frutasTrabalho);
                    System.out.println("\n--- Lista Ordenada via MergeSort ---");
                }
                exibirString(frutasTrabalho);

                System.out.println("\nDeseja pesquisar uma fruta específica? (1) Sim (2) Não");
                int pesquisar = lerOpcaoValida(scanner, 1, 2);
                if (pesquisar == -1) continue;

                if (pesquisar == 1) {
                    System.out.print("Digite o nome da fruta que deseja pesquisar: ");
                    String valorPesquisa = scanner.next();

                    int indice = pesquisaBinariaString(valorPesquisa, frutasTrabalho);

                    if (indice >= 0) {
                        System.out.printf("Fruta encontrada no índice: %d\n", indice);
                    } else {
                        System.out.println("Valor inexistente na lista.");
                    }
                }
            } else {
                System.out.print("Digite o tamanho da lista aleatória: ");
                int tamanho = lerNumeroPositivo(scanner);
                if (tamanho == -1) continue;

                System.out.print("Digite o valor mínimo: ");
                int valorMinimo = lerInteiroQualquer(scanner);
                if (valorMinimo == -1) continue;

                System.out.print("Digite o valor máximo: ");
                int valorMaximo = lerInteiroQualquer(scanner);
                if (valorMaximo == -1) continue;

                if (valorMinimo > valorMaximo) {
                    System.out.println("\n[ERRO] O valor mínimo não pode ser maior que o valor máximo! Retornando ao menu...");
                    continue;
                }

                int[] numeros = new int[tamanho];
                preencher(numeros, valorMinimo, valorMaximo);

                System.out.println("\n--- Lista Desordenada de Números ---");
                exibirInt(numeros);

                if (escolhaAlgoritmo == 1) {
                    quickSortInt(0, numeros.length - 1, numeros);
                    System.out.println("\n--- Lista Ordenada via QuickSort ---");
                } else {
                    mergeSortInt(0, numeros.length, numeros);
                    System.out.println("\n--- Lista Ordenada via MergeSort ---");
                }
                exibirInt(numeros);

                System.out.println("\nDeseja pesquisar um número específico? (1) Sim (2) Não");
                int pesquisar = lerOpcaoValida(scanner, 1, 2);
                if (pesquisar == -1) continue;

                if (pesquisar == 1) {
                    System.out.print("Digite o valor inteiro que deseja pesquisar: ");
                    int valorPesquisa = lerInteiroQualquer(scanner);
                    if (valorPesquisa == -1) continue;

                    int indice = pesquisaBinariaInt(valorPesquisa, numeros);

                    if (indice >= 0) {
                        System.out.printf("Número encontrado no índice: %d\n", indice);
                    } else {
                        System.out.println("Valor inexistente na lista.");
                    }
                }
            }

            System.out.println("\nDeseja continuar no programa? (1) Sim (2) Não");
            int continuar = lerOpcaoValida(scanner, 1, 2);
            if (continuar == -1 || continuar == 2) {
                break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado com sucesso!");
    }

    // --- FUNÇÕES DE VALIDAÇÃO E RETORNO AO MENU ---

    /**
     * Le um valor inteiro dentro do intervalo especificado [min, max].
     * Retorna -1 em caso de entrada invalida ou fora do intervalo para acionar o continue do menu.
     */
    public static int lerOpcaoValida(Scanner scanner, int min, int max) {
        try {
            int opcao = scanner.nextInt();
            if (opcao < min || opcao > max) {
                System.out.println("\n[OPÇÃO INVÁLIDA] Escolha um valor entre " + min + " e " + max + ". Retornando ao menu principal...");
                return -1;
            }
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("\n[ENTRADA INVÁLIDA] Digite apenas números inteiros! Retornando ao menu principal...");
            scanner.nextLine(); // Limpa o buffer do scanner
            return -1;
        }
    }

    /**
     * Le um inteiro positivo maior que zero.
     */
    public static int lerNumeroPositivo(Scanner scanner) {
        try {
            int valor = scanner.nextInt();
            if (valor <= 0) {
                System.out.println("\n[ENTRADA INVÁLIDA] O valor deve ser maior que zero! Retornando ao menu principal...");
                return -1;
            }
            return valor;
        } catch (InputMismatchException e) {
            System.out.println("\n[ENTRADA INVÁLIDA] Digite apenas números inteiros! Retornando ao menu principal...");
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Le qualquer numero inteiro evitando crash por texto.
     */
    public static int lerInteiroQualquer(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n[ENTRADA INVÁLIDA] Digite apenas números inteiros! Retornando ao menu principal...");
            scanner.nextLine();
            return -1;
        }
    }

    // --- MÉTODOS DE SUPORTE E ORDENAÇÃO ---

    public static void preencher(int[] v, int valorMinimo, int valorMaximo) {
        Random rd = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rd.nextInt(valorMinimo, valorMaximo + 1);
        }
    }

    public static void exibirInt(int[] v) {
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void exibirString(String[] v) {
        for (String s : v) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void quickSortString(int e, int d, String[] a) {
        if (d > e) {
            int i = particaoString(e, d, a);
            quickSortString(e, i - 1, a);
            quickSortString(i + 1, d, a);
        }
    }

    private static int particaoString(int e, int d, String[] a) {
        String pivo = a[d];
        int i = e - 1;

        for (int j = e; j < d; j++) {
            if (a[j].compareToIgnoreCase(pivo) <= 0) {
                i++;
                String aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        String aux = a[i + 1];
        a[i + 1] = a[d];
        a[d] = aux;
        return i + 1;
    }

    public static void quickSortInt(int e, int d, int[] a) {
        if (d > e) {
            int i = particaoInt(e, d, a);
            quickSortInt(e, i - 1, a);
            quickSortInt(i + 1, d, a);
        }
    }

    private static int particaoInt(int e, int d, int[] a) {
        int pivo = a[d];
        int i = e - 1;

        for (int j = e; j < d; j++) {
            if (a[j] <= pivo) {
                i++;
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        int aux = a[i + 1];
        a[i + 1] = a[d];
        a[d] = aux;
        return i + 1;
    }

    public static void mergeSortStr(int inicio, int tamanho, String[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSortStr(inicio, meio, v);
            mergeSortStr(meio, tamanho, v);
            intercalarStr(inicio, meio, tamanho, v);
        }
    }

    public static void intercalarStr(int inicio, int meio, int tamanho, String[] v) {
        String[] auxiliar = new String[tamanho - inicio];
        int i = inicio, j = meio, k = 0;

        while (i < meio && j < tamanho) {
            if (v[i].compareToIgnoreCase(v[j]) <= 0) {
                auxiliar[k++] = v[i++];
            } else {
                auxiliar[k++] = v[j++];
            }
        }

        while (i < meio) auxiliar[k++] = v[i++];
        while (j < tamanho) auxiliar[k++] = v[j++];

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public static void mergeSortInt(int inicio, int tamanho, int[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSortInt(inicio, meio, v);
            mergeSortInt(meio, tamanho, v);
            intercalarInt(inicio, meio, tamanho, v);
        }
    }

    public static void intercalarInt(int inicio, int meio, int tamanho, int[] v) {
        int[] auxiliar = new int[tamanho - inicio];
        int i = inicio, j = meio, k = 0;

        while (i < meio && j < tamanho) {
            if (v[i] <= v[j]) {
                auxiliar[k++] = v[i++];
            } else {
                auxiliar[k++] = v[j++];
            }
        }

        while (i < meio) auxiliar[k++] = v[i++];
        while (j < tamanho) auxiliar[k++] = v[j++];

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public static int pesquisaBinariaString(String valor, String[] v) {
        int inicio = 0;
        int fim = v.length - 1;

        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            int comparacao = valor.compareToIgnoreCase(v[meio]);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static int pesquisaBinariaInt(int valor, int[] v) {
        int inicio = 0;
        int fim = v.length - 1;

        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            if (valor == v[meio]) {
                return meio;
            } else if (valor > v[meio]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}
