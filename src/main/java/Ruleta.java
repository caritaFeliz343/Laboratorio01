import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    /**
     * Método principal: inicia el programa llamando al menú.
     */
    public static void main(String[] args) {
        menu();
    }

    /**
     * Controla el flujo principal del programa mostrando
     * un menú en consola.
     */
    public static void menu() {
        System.out.println("Menu");
        System.out.println("============");
        while (true){
            mostrarMenu();
        }
        // TODO: Repetir el menú hasta que el usuario elija salir.
    }
    public static void mostrarMenu(){
        // Mostrar las opciones disponibles
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir");
    }
    public static int leerOpcion(Scanner in){
        Scanner lectorOpcionObj = new Scanner(System.in);
        int opcionSeleccionada = lectorOpcionObj.nextInt();
        if (opcionSeleccionada == 1){
            // ejecutar iniciar ronda
        } else if (opcionSeleccionada == 2){
            // ejecutar ver estadisticas
        } else if (opcionSeleccionada == 3) {
            // ejecutar salir
        }
        return 0;
    }
}