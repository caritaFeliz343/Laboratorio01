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
        Scanner miScanner = new Scanner(System.in);
        int numeroOpcion = 0;
        do{
            mostrarMenu();
            numeroOpcion = leerOpcion(miScanner);
            ejecutarOpcion(numeroOpcion);
        } while(numeroOpcion != 3);
        // TODO: Repetir el menú hasta que el usuario elija salir.
    }
    public static void mostrarMenu(){
        // Mostrar las opciones disponibles
        System.out.println("\t\tMENU");
        System.out.println("====================");
        System.out.println("Selecciona una de las siguientes opciones:");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir");
    }
    public static int leerOpcion(Scanner in){
        int opcionSeleccionada = Integer.parseInt(in.next());
        return opcionSeleccionada;
    }
    public static void ejecutarOpcion(int opcion){
        if (opcion == 1) {
            //Iniciar ronda
        } else if (opcion == 2) {
            // Ver estadisticas
        } else if (opcion == 3) {
            System.out.println("esta es la opcion 3");
        }
    }
}