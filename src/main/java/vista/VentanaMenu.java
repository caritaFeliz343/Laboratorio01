package vista;

import javax.swing.*;
import java.awt.*;

import controlador.RuletaController;
import controlador.SessionController;

public class VentanaMenu
{

    private final SessionController sesion;
    private final RuletaController ruletaController;
    private final JFrame frame = new JFrame("Menu Ruleta");

    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JLabel lblUsuarioValor = new JLabel("");

    private final JLabel lblSaldo = new JLabel("Saldo actual:");
    private final JLabel lblSaldoValor = new JLabel("");

    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblEspacioNombre = new JLabel("");
    private final JButton btnCambiarNombre = new JButton("Cambiar nombre");

    private final JLabel lblDeposito = new JLabel("Monto a depositar:");
    private final JSpinner spinnerDeposito = new JSpinner(new SpinnerNumberModel(10, 1, 10, 1));
    private final JLabel lblEspacioDeposito = new JLabel("");
    private final JButton btnDepositar = new JButton("Depositar saldo");

    private final JLabel lblJugar = new JLabel("Jugar a la ruleta");
    private final JButton btnJugar = new JButton("Jugar");
    private final JLabel lblSalir = new JLabel("Cerrar sesion y volver a la pantalla de bienvenida");
    private final JButton btnSalir = new JButton("Salir");

    public VentanaMenu(SessionController sesion, RuletaController ruletaController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        frame.setSize(640,480);
        frame.setLayout(new GridLayout(8,2,10,10));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(lblUsuario);
        frame.add(lblUsuarioValor);
        frame.add(lblSaldo);
        frame.add(lblSaldoValor);
        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblEspacioNombre);
        frame.add(btnCambiarNombre);
        frame.add(lblDeposito);
        frame.add(spinnerDeposito);
        frame.add(lblEspacioDeposito);
        frame.add(btnDepositar);
        frame.add(lblJugar);
        frame.add(btnJugar);
        frame.add(lblSalir);
        frame.add(btnSalir);

        btnJugar.addActionListener(e -> irAJugarRuleta());
        btnSalir.addActionListener(e -> irAVentanaSaludo());

        lblUsuarioValor.setText(sesion.getUsername());
        txtNombre.setText(sesion.getNombreUsuario());
    }
    public void mostrarVentana()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void irAJugarRuleta()
    {
        frame.dispose();
        VentanaRuleta ventanaRuleta = new VentanaRuleta(sesion, ruletaController);
        ventanaRuleta.mostrarVentanaRuleta();
    }
    private void irAVentanaSaludo()
    {
        frame.dispose();
        sesion.cerrarSesion();
        VentanaSaludo ventanaSaludo = new VentanaSaludo(sesion);
        ventanaSaludo.mostrarVentanaSaludo();
    }
}

