package modelo;

public class Resultado
{
    private final TipoApuesta tipoApuesta;
    private final int numeroRuleta;
    private final boolean esRojo;
    private final boolean acierto;
    private final int monto;

    public Resultado(int numeroRuleta, TipoApuesta tipo, boolean esRojo, boolean acierto, int monto)
    {
        this.numeroRuleta = numeroRuleta;
        this.tipoApuesta = tipo;
        this.esRojo = esRojo;
        this.acierto = acierto;
        this.monto = monto;
    }

    public int getNumeroRuleta()
    {
        return numeroRuleta;
    }
    public TipoApuesta getTipo()
    {
        return tipoApuesta;
    }
    public boolean getEsRojo()
    {
        return esRojo;
    }
    public boolean getEsAcierto()
    {
        return acierto;
    }
    public int getMonto()
    {
        return monto;
    }
}
