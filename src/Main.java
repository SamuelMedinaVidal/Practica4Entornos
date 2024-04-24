import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int limite = obtenerLimite(teclado);
        int[] primos = generarPrimos(limite);
        imprimirVector("Vector de primos hasta: ", primos);
    }
    private static int obtenerLimite(Scanner teclado) {
        System.out.println("Introduce el número para la criba de Eratóstenes: ");
        return teclado.nextInt();
    }
    private static void imprimirVector(String mensaje, int[] vector) {
        System.out.println("\n" + mensaje);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
    private static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Vector vacío
        }
        boolean[] esPrimo = new boolean[max + 1];
        inicializarArray(esPrimo);
        cribaEratostenes(esPrimo);
        return obtenerPrimos(esPrimo);
    }
    private static void inicializarArray(boolean[] esPrimo) {
        for (int i = 0; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;
    }
    private static void cribaEratostenes(boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < esPrimo.length; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }
    private static int[] obtenerPrimos(boolean[] esPrimo) {
        int cuenta = contarPrimos(esPrimo);
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) primos[j++] = i;
        }
        return primos;
    }
    private static int contarPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) cuenta++;
        }
        return cuenta;
    }
}
