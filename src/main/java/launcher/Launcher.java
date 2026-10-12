package launcher;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import controlador.ResultadoController;
import controlador.RuletaController;
import controlador.SessionController;
import modelo.Ruleta;
import vista.VentanaSaludo;
import javax.swing.*;

public class Launcher
{
    private static final int SALDO_INICIAL = 1000;

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
        } catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        SessionController sesion = new SessionController();
        Ruleta ruleta = new Ruleta(SALDO_INICIAL);
        ResultadoController resultadoController = new ResultadoController(sesion);
        RuletaController ruletaController = new RuletaController(sesion, ruleta);
        VentanaSaludo saludo = new VentanaSaludo(sesion,ruletaController,resultadoController);
        saludo.mostrarVentanaSaludo();
    }
}
