package controlador;

import modelo.Resultado;
import modelo.Ruleta;
public class RuletaController
{
    private static final int SALDO_INICIAL = 1000;
    private final Ruleta ruleta;

    public RuletaController()
    {
        this.ruleta = new Ruleta(SALDO_INICIAL);
    }
    public Resultado realizarApuesta(char tipo, int monto)
    {
        return ruleta.apostar(tipo, monto);
    }
    public int getSaldo()
    {
        return ruleta.getSaldo();
    }
}
