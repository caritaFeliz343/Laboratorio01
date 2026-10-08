package launcher;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import controlador.SessionController;
import vista.VentanaSaludo;
import javax.swing.*;

public class Launcher
{
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
        VentanaSaludo saludo = new VentanaSaludo(sesion);
        saludo.mostrarVentanaSaludo();
    }
}
