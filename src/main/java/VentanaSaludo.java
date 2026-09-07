import javax.swing.*;
import java.awt.*;

public class VentanaSaludo
{
    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JLabel txtBienvenida = new JLabel("Bienvenido al casino Black Cat");
    private final JLabel txtOpciones = new JLabel("¿Que deseas hacer?");
    private final JButton btnLogin = new JButton("Iniciar sesion");
    public VentanaSaludo()
    {
        frame.setSize(640,480);
        frame.setLayout(new GridLayout(3,1,10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txtBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(txtBienvenida);
        txtOpciones.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(txtOpciones);
        frame.add(btnLogin);
        btnLogin.addActionListener(e -> irALogin());
    }
    public void mostrarVentanaSaludo()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void irALogin()
    {
        frame.dispose();
        VentanaLogin login = new VentanaLogin();
        login.mostrarVentana();
    }
}
