import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar el programa de la criba de Eratóstenes.
 */
public class JavaDoc {

    /**
     * Método principal que solicita al usuario un número y muestra los números primos hasta ese número.
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int limite = obtenerLimite(teclado);
        int[] primos = generarPrimos(limite);
        imprimirVector("Vector de primos hasta:", primos);
    }

    /**
     * Solicita al usuario un número entero positivo.
     * @param teclado Objeto Scanner para leer la entrada del usuario.
     * @return El número introducido por el usuario.
     */
    private static int obtenerLimite(Scanner teclado) {
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        return teclado.nextInt();
    }

    /**
     * Imprime un vector de números en la consola.
     * @param mensaje El mensaje que precede al vector.
     * @param vector El vector de números a imprimir.
     */
    private static void imprimirVector(String mensaje, int[] vector) {
        System.out.println("\n" + mensaje);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Genera y devuelve un array de números primos hasta el número especificado.
     * @param max El número máximo hasta el cual se generan los números primos.
     * @return Un array de números primos hasta el número especificado.
     */
    private static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Vector vacío
        }
        boolean[] esPrimo = new boolean[max + 1];
        inicializarArray(esPrimo);
        cribaEratostenes(esPrimo);
        return obtenerPrimos(esPrimo);
    }

    /**
     * Inicializa un array de booleanos con el valor true.
     * @param esPrimo En el array de booleanos a inicializar.
     */
    private static void inicializarArray(boolean[] esPrimo) {
        for (int i = 0; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Realiza la criba de Eratóstenes para encontrar números primos.
     * @param esPrimo El array de booleanos que indica si un número es primo o no.
     */
    private static void cribaEratostenes(boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < esPrimo.length; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Obtiene los números primos del array de booleanos.
     * @param esPrimo El array de booleanos que indica si un número es primo o no.
     * @return Un array de números primos.
     */
    private static int[] obtenerPrimos(boolean[] esPrimo) {
        int cuenta = contarPrimos(esPrimo);
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) primos[j++] = i;
        }
        return primos;
    }

    /**
     * Cuenta los números primos en el array de booleanos.
     * @param esPrimo El array de booleanos que indica si un número es primo o no.
     * @return La cantidad de números primos en el array.
     */
    private static int contarPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) cuenta++;
        }
        return cuenta;
    }
}
