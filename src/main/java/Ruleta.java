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
    public static Scanner miScanner = new Scanner(System.in);
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    /**
     * Método principal: inicia el programa llamando al menú.
     */
    public static void main(String[] args)
    {
        menu();
    }

    /**
     * Controla el flujo principal del programa mostrando
     * un menú en consola.
     */
    public static void menu()
    {
        int numeroOpcion = 0;
        do
        {
            mostrarMenu();
            numeroOpcion = leerOpcion(miScanner);
            ejecutarOpcion(numeroOpcion, miScanner);
        }
        while(numeroOpcion != 3);
    }
    public static void mostrarMenu()
    {
        System.out.println("\t\tMENU");
        System.out.println("====================");
        System.out.println("Selecciona una de las siguientes opciones:");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir\n");
    }
    public static int leerOpcion(Scanner in)
    {
        int opcionSeleccionada = Integer.parseInt(in.next());
        return opcionSeleccionada;
    }
    public static void ejecutarOpcion(int opcion, Scanner in)
    {
        if (opcion == 1)
        {
            iniciarRonda(miScanner);
        }
        else if (opcion == 2)
        {
            // Ver estadisticas
        }
        else if (opcion == 3)
        {
            System.out.println("Hasta pronto!");
        }
    }
    public static void iniciarRonda(Scanner in)
    {
        System.out.println("Seleccione su tipo de apuesta: Par/impar o Rojo/Negro");
        char tipoDeApuesta = leerTipoApuesta(miScanner);
        if (tipoDeApuesta == 'P')
        {
            System.out.println("Apuesta par");
        }
        else if (tipoDeApuesta == 'I')
        {
            System.out.println("Apuesta Impar");
        }
        else if (tipoDeApuesta == 'R')
        {
            System.out.println("Apuesta Rojo");
        }
        else if (tipoDeApuesta == 'N')
        {
            System.out.println("Apuesta Negro");
        }
    }
    public static char leerTipoApuesta(Scanner in)
    {
        char tipoDeApuesta = in.next().charAt(0);
        // TODO: Leer y validar el tipo de apuesta.
        return tipoDeApuesta;
    }
}