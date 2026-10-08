package vista;

import controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin {
    private final SessionController sesion;
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegresar = new JButton("Regresar");
    /**
     * Constructor que inicializa la ventana de inicio de sesión.
     * Configura sus componentes y eventos.
     */
    public VentanaLogin(SessionController sesion) {
        this.sesion = sesion;

        frame.setSize(640,480);
        frame.setLayout(new GridLayout(3,2,10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnIngresar);
        btnIngresar.addActionListener(e -> login());
        frame.add(btnRegresar);
        btnRegresar.addActionListener(e -> regresar());
    }
    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
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
    /**
     * Gestiona el inicio de sesión al presionar el botón.
     * Debe validar las credenciales ingresadas y abrir la siguiente
     * ventana o mostrar un mensaje de error.
     */
    private void login()
    {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());
        boolean validadoUsuario = sesion.iniciarSession(usuario,clave);
        if (validadoUsuario)
        {
            JOptionPane.showMessageDialog(frame, "Bienvenido, " + sesion.getNombreUsuario());
            frame.dispose();
            VentanaMenu ventanaMenu = new VentanaMenu();
            ventanaMenu.mostrarVentana();
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre de usuario o contraseña correctos","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}
