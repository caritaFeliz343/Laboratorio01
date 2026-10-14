package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Ruleta {
    private static final int NUMERO_MAXIMO_RULETA = 37;

    private final List<Resultado> resultados = new ArrayList<>();
    private static final Random rng = new Random();
    private int saldo;
    private final int saldoInicial;
    private static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23, 25, 27, 30, 32, 34, 36
    };

    public Ruleta(int saldoInicial)
    {
        this.saldoInicial = Math.max(0, saldoInicial);
        this.saldo = this.saldoInicial;
    }
    public Ruleta()
    {
        this(0);
    }

    private int girarRuleta()
    {
        int numeroRandom = rng.nextInt(0,NUMERO_MAXIMO_RULETA);
        return numeroRandom;
    }
    private boolean evaluarResultado(int numero, TipoApuesta tipo)
    // true si acerto, false si no
    {
        if (numero == 0)
        {
            return false;
        }
        return switch (tipo)
        {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }
    private boolean esRojo(int n)
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

    private int modificadorGanarPerder(int monto, boolean acierto)
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

    public int getSaldo()
    {
        return saldo;
    }

    public Resultado apostar(TipoApuesta tipo, int monto)
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
        Resultado resultado = new Resultado(numeroRuleta, tipo, esRojo(numeroRuleta), acierto, monto);
        resultados.add(resultado);
        return resultado;
    }
    public void depositar(int monto)
    {
        if (monto < 1)
        {
            throw new IllegalArgumentException("El monto del deposito debe ser mayor a 0");
        }
        saldo += monto;
    }

    public void reiniciarSaldo()
    {
        saldo = saldoInicial;
    }
}