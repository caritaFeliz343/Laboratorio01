import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistro {
    // --- Lista dinámica de usuarios ---
    public static final List<Usuario> USUARIOS = new ArrayList<>();
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JButton btnIngresar = new JButton("Registrarse");
    private final JButton btnRegresar = new JButton("Regresar");

    public VentanaRegistro()
    {
        frame.setSize(640,480);
        frame.setLayout(new GridLayout(4,2,10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        frame.add(btnRegresar);
        btnRegresar.addActionListener(e -> regresar());
    }
    public void regresar()
    {
        frame.dispose();
        VentanaSaludo ventanaSaludo = new VentanaSaludo();
        ventanaSaludo.mostrarVentanaSaludo();
    }
    public void mostrarVentana()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}