package controlador;

import modelo.Resultado;
import modelo.Ruleta;
import modelo.TipoApuesta;

public class RuletaController
{
    private static final int SALDO_INICIAL = 1000;
    private final Ruleta ruleta;
    private final SessionController sesion;

    public RuletaController(SessionController sesion)
    {
        this.ruleta = new Ruleta(SALDO_INICIAL);
        this.sesion = sesion;
    }
    public Resultado realizarApuesta(TipoApuesta tipo, int monto)
    {
        Resultado resultado = ruleta.apostar(tipo, monto);
        sesion.getUsuarioActual().agregarResultadoHistorial(resultado); // aqui sesion.getUsuarioActual es como si fuera el usuario en si.
        return resultado;
    }
    public int getSaldo()
    {
        return ruleta.getSaldo();
    }
    public void depositar(int monto)
    {
        ruleta.depositar(monto);
    }
}
