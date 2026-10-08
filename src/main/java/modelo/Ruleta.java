package modelo;

import java.util.Random;
public class Ruleta {
    private static final int MAX_HISTORIAL = 100;
    private static final int NUMERO_MAXIMO_RULETA = 37;
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;
    private static final Random rng = new Random();
    private int saldo;
    private static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public Ruleta(int saldoInicial)
    {
        this.saldo = Math.max(0, saldoInicial);
    }
    public Ruleta()
    {
        this(0);
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
    public void registrarResultado(int numero, int apuesta, boolean acierto)
    {
        historialNumeros[historialSize] = numero;
        historialApuestas[historialSize] = apuesta;
        historialAciertos[historialSize] = acierto;
        historialSize++;
    }
    public int totalApostado()
    {
        int sumaApuestas = 0;
        for (int i = 0; i < historialSize ; i++)
        {
            sumaApuestas += historialApuestas[i];
        }
        return sumaApuestas;
    }
    public int totalAciertos()
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
    public int apuestaNeta(int numero)
    {
        int dineroDespuesModificador = numero;
        saldo += dineroDespuesModificador;
        return saldo;
    }

    public int getSaldo()
    {
        return saldo;
    }

    public Resultado apostar(char tipo, int monto)
    {
        if (monto < 1)
        {
            throw new IllegalArgumentException("El monto de la apuesta debe ser mayor a 0");
        }
        if (monto > saldo)
        {
            throw new IllegalArgumentException("El monto de la apuesta no puede ser mayor al saldo");
        }
        int numeroRuleta = girarRuleta();
        boolean acierto = evaluarResultado(numeroRuleta, tipo);
        saldo += modificadorGanarPerder(monto, acierto);
        registrarResultado(numeroRuleta, tipo, acierto);
        return new Resultado(numeroRuleta, tipo, esRojo(numeroRuleta), acierto, monto);
    }
}