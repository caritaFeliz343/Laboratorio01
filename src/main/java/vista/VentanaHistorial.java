package vista;

import controlador.ResultadoController;
import controlador.RuletaController;
import controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial
{
    private final SessionController sesion;
    private final RuletaController ruletaController;
    private final ResultadoController resultadoController;

    private final JFrame frame = new JFrame("Historial - Casino Black Cat");
    private final JTextArea areaHistorial = new JTextArea();

    public VentanaHistorial(SessionController sesion, RuletaController ruletaController, ResultadoController resultadoController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        this.resultadoController = resultadoController;

        frame.setSize(640,480);
        frame.setLayout(new GridLayout(8,2,10,10));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mostrarVentanaHistorial()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

