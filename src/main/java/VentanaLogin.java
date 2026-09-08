import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List<Usuario> USUARIOS = new ArrayList<>();
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
    public VentanaLogin() {
        USUARIOS.add(new Usuario("caritaFeliz343","hola123","Christian"));
        USUARIOS.add(new Usuario("sebasApp","321adios","Sebastian"));

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
        String validadoNombre = validarCredenciales(usuario,clave);
        if (validadoNombre != "")
        {
            JOptionPane.showMessageDialog(frame, "Bienvenido, " + validadoNombre);
            frame.dispose();
            Ruleta.menu();
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Ingrese el nombre de usuario o contraseña correctos");
        }
    }
    /**
     * Valida las credenciales ingresadas utilizando la lista de usuarios.
     *
     * @param u nombre de usuario ingresado
     * @param p contraseña ingresada
     * @return el nombre del usuario si las credenciales son válidas o una cadena vacía
    si no existe una coincidencia
     */
    private String validarCredenciales(String u, String p)
    {
        for (Usuario usuario : USUARIOS)
        {
            if (usuario.validarCredenciales(u,p))
            {
                return usuario.getNombre();
            }
        }
        return "";
    }
}
