package vista;

import controlador.RuletaController;
import modelo.Resultado;
import modelo.TipoApuesta;
import javax.swing.*;
import java.awt.event.ActionListener;
import controlador.SessionController;

public class VentanaRuleta
{
    private final SessionController sesion;
    private final RuletaController ruletaController;
    private static final int ALTO_FILA = 25;
    private static final int ANCHO_OPCIONES = 80;
    private static final int ANCHO_TEXTO = 220;
    private static final int ANCHO_COMBO = 120;
    private static final int ANCHO_RESULTADO = 560;
    private static final int POS_Y_INICIAL = 20;
    private static final int SEPARACION_Y = 30;
    private static final int POS_X_TEXTO = 20;
    private static final int POS_X_RESULTADO_RULETA = 200;
    private static final int POS_X_OPCION1 = 320;
    private static final int POS_X_OPCION2 = 420;
    private static final int MONTO_INICIAL = 10;
    private static final int MONTO_MINIMO = 1;
    private static final int MONTO_MAXIMO = 5000;
    private static final int MONTO_PASO = 1;


    private final JFrame frame = new JFrame("Ruleta");

    private final JComboBox<TipoApuesta> cboTipoApuesta = new JComboBox<>(TipoApuesta.values());

    private final JSpinner spinnerMonto = new JSpinner(new SpinnerNumberModel(MONTO_INICIAL, MONTO_MINIMO, MONTO_MAXIMO, MONTO_PASO));
    private final JTextField textFieldBalance = new JTextField("",10);

    private final JButton btnGirar = new JButton("Girar");
    private final JLabel lblResultado = new JLabel("");

    private final JButton btnSalir = new JButton("Salir");

    public VentanaRuleta(SessionController sesion, RuletaController ruletaController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        frame.setSize(640,480);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarFila("Selecciona el tipo de apuesta",0,cboTipoApuesta);
        agregarFila("Selecciona la cantidad a apostar",1,spinnerMonto);
        agregarFila("",2,btnGirar);
        agregarFila("Saldo", 3,textFieldBalance);
        agregarFila("Resultado de la ruleta",4,lblResultado);
        agregarFila("Salir de la ruleta",5,btnSalir);
        btnGirar.addActionListener(e -> girar());
        btnSalir.addActionListener(e -> irAVentanaMenu());
        textFieldBalance.setEditable(false);
        mostrarBalanceTotal();
    }
    public void mostrarVentanaRuleta()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void agregarFila(String texto, int numeroFila,JComboBox<TipoApuesta> cboTipoApuesta)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);

        cboTipoApuesta.setBounds(POS_X_OPCION1,posicionY,ANCHO_COMBO,ALTO_FILA);
        frame.add(etiqueta);
        frame.add(cboTipoApuesta);
    }
    private void agregarFila(String texto, int numeroFila,JSpinner spinnerA)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);

        spinnerA.setBounds(POS_X_OPCION1,posicionY,ANCHO_OPCIONES,ALTO_FILA);
        frame.add(etiqueta);
        frame.add(spinnerA);
    }
    private void agregarFila(String texto, int numeroFila, JButton botonA)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        botonA.setBounds(POS_X_OPCION1,posicionY,ANCHO_OPCIONES,ALTO_FILA);

        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);
        frame.add(botonA);
        frame.add(etiqueta);
    }
    private void agregarFila(String texto, int numeroFila, JLabel lbl)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        lbl.setBounds(POS_X_RESULTADO_RULETA,posicionY,ANCHO_RESULTADO,ALTO_FILA);

        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);
        frame.add(etiqueta);
        frame.add(lbl);
    }
    private void agregarFila(String texto, int numeroFila, JTextField campoTexto)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        campoTexto.setBounds(POS_X_OPCION1,posicionY,ANCHO_RESULTADO,ALTO_FILA);

        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);
        frame.add(etiqueta);
        frame.add(campoTexto);
    }

    private void girar()
    {
        int monto = (int) spinnerMonto.getValue();
        TipoApuesta tipo = (TipoApuesta) cboTipoApuesta.getSelectedItem();
        try
        {
            Resultado resultado = ruletaController.realizarApuesta(tipo, monto);
            mostrarResultado(resultado);
        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Apuesta inválida", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarResultado(Resultado resultado)
    {
        String colorOriginal = obtenerColorResultado(resultado);
        String veredicto;
        if (resultado.getEsAcierto())
        {
            veredicto = "Ganaste!!!";
        }
        else
        {
            veredicto = "Perdiste...";
        }
        lblResultado.setText("Número " + resultado.getNumeroRuleta() + "("+colorOriginal+")" + " | Apuesta Tipo " + resultado.getTipo() + " | Monto=$" + resultado.getMonto() + " | " + veredicto);
        mostrarBalanceTotal();
    }
    private String obtenerColorResultado(Resultado resultado)
    {
        String colorRetornado;
        boolean esRojo = resultado.getEsRojo();
        if (esRojo)
        {
            colorRetornado = "Rojo";
        }
        else
        {
            colorRetornado = "Negro";
        }
        return colorRetornado;
    }
    private void mostrarBalanceTotal()
    {
         String textoSaldo = Integer.toString(ruletaController.getSaldo());
         textFieldBalance.setText(textoSaldo);
    }
    private void irAVentanaMenu()
    {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(sesion,ruletaController);
        ventanaMenu.mostrarVentana();
    }
}
