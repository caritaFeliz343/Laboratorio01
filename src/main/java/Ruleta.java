import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static final int NUMERO_MAXIMO_RULETA = 37;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int contadorDinero = 0;
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
        System.out.println("============================");
        System.out.println("\tMENU casino Black Cat");
        System.out.println("============================");
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
            iniciarRonda(in);
        }
        else if (opcion == 2)
        {
            mostrarEstadisticas();
        }
        else if (opcion == 3)
        {
            System.out.println("Hasta pronto!");
        }
    }
    public static void iniciarRonda(Scanner in)
    {
        char tipoDeApuesta = leerTipoApuesta(in);
        int cantidadDeApuesta = leerMontoApuesta(in);
        int numeroRuleta = girarRuleta();
        boolean resultadoRonda = evaluarResultado(numeroRuleta,tipoDeApuesta);
        int dineroModificado = modificadorGanarPerder(cantidadDeApuesta,resultadoRonda);
        apuestaNeta(dineroModificado);
        registrarResultado(numeroRuleta,cantidadDeApuesta,resultadoRonda);
        mostrarResultado(numeroRuleta,tipoDeApuesta,cantidadDeApuesta,resultadoRonda);
    }
    public static char leerTipoApuesta(Scanner in)
    {
        System.out.println("Seleccione su tipo de apuesta: (P)Par/(I)impar o (R)Rojo/(N)Negro, usando la inicial: ");
        char tipoDeApuesta = in.next().charAt(0);
        return tipoDeApuesta;
    }
    public static int leerMontoApuesta(Scanner in)
    {
        System.out.println("Especifique la cantidad que quiere apostar: ");
        int cantidadApuesta = in.nextInt();
        return cantidadApuesta;
    }
    public static int girarRuleta()
    {
        int numeroRandom = rng.nextInt(0,NUMERO_MAXIMO_RULETA);
        return numeroRandom;
    }

    public static boolean evaluarResultado(int numero, char tipo)
    // true si acerto, false si no
    {
        boolean numeroRojo = esRojo(numero);
        boolean resultado = false;
        if (tipo == 'R' && numeroRojo)
        {
            resultado = true;
        }
        else if (tipo == 'R' && !numeroRojo)
        {
            resultado = false;
        }
        else if (tipo == 'N' && !numeroRojo)
        {
            resultado = true;
        }
        else if (tipo == 'P' && numero % 2 == 0)
        {
            resultado = true;
        }
        else if (tipo == 'I' && numero % 2 == 0)
        {
            resultado = false;
        }
        else if (tipo == 'I' && numero % 2 != 0)
        {
            resultado = true;
        }
        return resultado;
    }
    public static boolean esRojo(int n)
    {
        boolean boolRetorno = false;
        for (int numero : numerosRojos)
        {
            if (n == numero)
            {
                boolRetorno = true;
                break;
            }
            else
            {
                boolRetorno = false;
            }
        }
        return boolRetorno;
    }
    public static void registrarResultado(int numero, int apuesta, boolean acierto)
    {
        historialNumeros[historialSize] = numero;
        historialApuestas[historialSize] = apuesta;
        historialAciertos[historialSize] = acierto;
        historialSize++;
    }
    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto)
    {
        System.out.println("Tu numero fue: "+numero);
        System.out.println("Tu apuesta fue al: "+tipo);
        System.out.println("Apostaste: $"+monto);
        if (acierto)
        {
            System.out.println("Felicidades! Ganaste!");
        }
        else
        {
            System.out.println("Que triste... Perdiste!");
        }
    }
    public static int totalApostado()
    {
        int sumaApuestas = 0;
        for (int i = 0; i < historialSize ; i++)
        {
            sumaApuestas += historialApuestas[i];
        }
        return sumaApuestas;
    }
    public static int totalAciertos()
    {
        // Cantidad total de aciertos
        int sumaAciertos = 0;
        for (int i = 0; i < historialSize ; i++)
        {
            if (historialAciertos[i])
            {
                sumaAciertos++;
            }
        }
        return sumaAciertos;
    }
    public static void porcentajeDeAciertos()
    {
        float porcentajeAciertos = 0;
        if (historialSize != 0)
        {
            porcentajeAciertos = (float)(totalAciertos() * 100) / historialSize;
            System.out.println("Tu porcentaje de aciertos es: "+porcentajeAciertos+"%");
        }
        else
        {
            System.out.println("Tu porcentaje de aciertos es: No has jugado todavia");
        }
    }
    public static int modificadorGanarPerder(int monto, boolean acierto)
    {
        if (acierto)
        {
            monto *=2;
        }
        else
        {
            monto *=-1;
        }
        return monto;
    }
    public static int apuestaNeta(int numero)
    {
        int dineroDespuesModificador = numero;
        contadorDinero += dineroDespuesModificador;
        return contadorDinero;
    }
    public static void mostrarEstadisticas()
    {
        System.out.println("Haz jugado: "+ historialSize + " rondas");
        int totalApostado = totalApostado();
        System.out.println("Haz apostado en total: $" + totalApostado);
        int totalAciertos = totalAciertos();
        System.out.println("Haz tenido: " + totalAciertos + " aciertos");
        porcentajeDeAciertos();

        // Ganancia o perdida neta
        System.out.println("Tu apuesta neta es: $"+contadorDinero);
    }
}