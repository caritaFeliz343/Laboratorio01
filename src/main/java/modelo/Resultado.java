package modelo;

public class Resultado
{
    private final int numeroRuleta;
    private final char tipo;
    private final boolean esRojo;
    private final boolean acierto;
    private final int monto;

    public Resultado(int numeroRuleta, char tipo, boolean esRojo, boolean acierto, int monto)
    {
        this.numeroRuleta = numeroRuleta;
        this.tipo = tipo;
        this.esRojo = esRojo;
        this.acierto = acierto;
        this.monto = monto;
    }

    public int getNumeroRuleta()
    {
        return numeroRuleta;
    }
    public char getTipo()
    {
        return tipo;
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
