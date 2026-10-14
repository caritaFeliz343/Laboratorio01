package vista;

import controlador.ResultadoController;
import controlador.RuletaController;
import controlador.SessionController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHistorial
{
    private final SessionController sesion;
    private final RuletaController ruletaController;
    private final ResultadoController resultadoController;

    private final int POS_X_INICIAL = 20;
    private final int POS_Y_BOTON = 380;
    private final int ANCHO_BOTON = 100;
    private final int ALTURA_BOTON = 50;
    private final int POS_Y_SCROLL = 10;
    private final int ANCHO_SCROLL = 580;
    private final int ALTURA_SCROLL = 300;
    private final JFrame frame = new JFrame("Historial - Casino Black Cat");
    private final JTextArea areaHistorial = new JTextArea();
    private final JScrollPane scrollHistorial = new JScrollPane(areaHistorial);

    private final JButton btnVolver = new JButton("Volver");

    public VentanaHistorial(SessionController sesion, RuletaController ruletaController, ResultadoController resultadoController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        this.resultadoController = resultadoController;

        frame.setSize(640, 480);
        frame.setLayout(null);
        frame.setResizable(false);
        areaHistorial.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnVolver.setBounds(POS_X_INICIAL, POS_Y_BOTON, ANCHO_BOTON, ALTURA_BOTON);
        frame.add(btnVolver);
        btnVolver.addActionListener(e -> regresarMenu());
        mostrarHistorial();
        scrollHistorial.setBounds(POS_X_INICIAL, POS_Y_SCROLL, ANCHO_SCROLL, ALTURA_SCROLL);
        frame.add(scrollHistorial);
    }

    public void mostrarVentanaHistorial()
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

    private void mostrarHistorial()
    {
        List<String> lineaHistorial = resultadoController.mostrarHistorialTexto(sesion);
        if (lineaHistorial.isEmpty())
        {
            areaHistorial.setText("Todavia no has jugado. ¡Ve a probar tu suerte!");
        } else
        {
            areaHistorial.setText(String.join("\n", lineaHistorial));
        }
    }
}

