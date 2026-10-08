package vista;

import controlador.SessionController;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final SessionController sesion;
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JButton btnRegistrarse = new JButton("Registrarse");
    private final JButton btnRegresar = new JButton("Regresar");

    public VentanaRegistro(SessionController sesion)
    {
        this.sesion = sesion;
        frame.setSize(640,480);
        frame.setLayout(new GridLayout(4,2,10,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);

        frame.add(btnRegistrarse);
        btnRegistrarse.addActionListener(e -> registrarse());
        frame.add(btnRegresar);
        btnRegresar.addActionListener(e -> regresar());
    }
    private void regresar()
    {
        frame.dispose();
        VentanaSaludo ventanaSaludo = new VentanaSaludo(sesion);
        ventanaSaludo.mostrarVentanaSaludo();
    }
    private void irALogin()
    {
        frame.dispose();
        VentanaLogin ventanaLogin = new VentanaLogin(sesion);
        ventanaLogin.mostrarVentana();
    }
    public void mostrarVentana()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void registrarse()
    {
        String username = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());
        String nombr = txtNombre.getText();

        try
        {
            sesion.registrarUsuario(username,clave,nombr);
            JOptionPane.showMessageDialog(frame, "Usuario registrado con exito.\nPorfavor inicie sesion.");
            irALogin();
        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios","Error critico!!!!",JOptionPane.ERROR_MESSAGE);
        }
    }
}