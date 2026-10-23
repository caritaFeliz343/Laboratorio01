package vista;

import controlador.ResultadoController;
import controlador.RuletaController;
import controlador.SessionController;

import javax.swing.*;

public class VentanaEstadisticas
{
    private final SessionController sesion;
    private final RuletaController ruletaController;
    private final ResultadoController resultadoController;
    private final int POS_X_INICIAL = 20;
    private final int POS_Y_BOTON = 380;
    private final int ANCHO_BOTON = 100;
    private final int ALTURA_BOTON = 50;

    private final JButton btnVolver = new JButton("Volver");

    private final JFrame frame = new JFrame("Estadisticas - Casino Black Cat");

    public VentanaEstadisticas(SessionController sesion, RuletaController ruletaController, ResultadoController resultadoController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        this.resultadoController = resultadoController;

        frame.setSize(640, 480);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnVolver.setBounds(POS_X_INICIAL, POS_Y_BOTON, ANCHO_BOTON, ALTURA_BOTON);
        frame.add(btnVolver);
        btnVolver.addActionListener(e -> regresarMenu());

    }

    public void mostrarVentanaEstadisticas()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void regresarMenu()
    {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(sesion, ruletaController, resultadoController);
        ventanaMenu.mostrarVentana();
    }
}
