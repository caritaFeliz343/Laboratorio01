import javax.swing.*;

public class VentanaMenu
{
    //TODO: tiene que: dejar ir a jugar, cerrar sesion, mostrar historial
    private final JFrame frame = new JFrame("Menu Ruleta");
    public VentanaMenu()
    {
        frame.setSize(640,480);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mostrarVentana()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

