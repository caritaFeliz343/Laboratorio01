package controlador;

import modelo.Resultado;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ResultadoController
{
    private final SessionController sesion;

    public ResultadoController(SessionController sesion)
    {
        this.sesion = sesion;
    }

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
    public String getVeredicto(Resultado resultado)
    {
        String veredicto;
        if (resultado.getEsAcierto())
        {
            veredicto = "Ganaste!!!1111";
        }
        else
        {
            veredicto = "Perdiste.....";
        }
        return veredicto;
    }

    public String getTextoResultado(Resultado resultado)
    {
        return "Número " + resultado.getNumeroRuleta() + "("+getColor(resultado)+")" + " | Apuesta Tipo " + resultado.getTipo() + " | Monto=$" + resultado.getMonto() + " | " + getVeredicto(resultado);
    }

    public List<String> mostrarHistorialTexto()
    {
        List<String> historialTexto = new ArrayList<>();
        List<Resultado> historialResultados = sesion.getUsuarioActual().getHistorialResultados();
        for (Resultado resultado : historialResultados)
        {
            historialTexto.add("Partida " + (historialResultados.indexOf(resultado)+1)+")"+" "+getTextoResultado(resultado));
        }
        return historialTexto;
    }
}
