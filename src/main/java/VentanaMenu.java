import javax.swing.*;
import java.awt.*;

public class VentanaMenu
{
    //TODO: tiene que: dejar ir a jugar, cerrar sesion
    private final JFrame frame = new JFrame("Menu Ruleta");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnSalir = new JButton("Salir");
    private final JLabel lblSalir = new JLabel("Cerrar sesion y volver a la pantalla de bienvenida");
    private final JLabel lblJugar = new JLabel("Jugar a la ruleta");

    public VentanaMenu()
    {
        frame.setSize(640,480);
        frame.setLayout(new GridLayout(3,2,10,10));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(lblJugar);
        frame.add(btnJugar);
        frame.add(lblSalir);
        frame.add(btnSalir);
        btnJugar.addActionListener(e -> irAJugarRuleta());

    }
    public void mostrarVentana()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void irAJugarRuleta()
    {
        frame.dispose();
        VentanaRuleta ventanaRuleta = new VentanaRuleta();
        ventanaRuleta.mostrarVentanaRuleta();

    }
}

