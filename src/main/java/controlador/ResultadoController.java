package controlador;

import modelo.Resultado;
public class ResultadoController
{
    public String getColor(Resultado resultado)
    {
        String color;
        if (resultado.getEsVerde())
        {
            color = "Verde";
        }
        else if (resultado.getEsRojo())
        {
            color = "Rojo";
        }
        else
        {
            color = "Negro";
        }
        return color;
    }

}
