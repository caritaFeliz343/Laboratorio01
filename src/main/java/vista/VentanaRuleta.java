package vista;

import controlador.RuletaController;
import modelo.Resultado;
import modelo.Ruleta;

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

    private final JRadioButton opcionTipoApuestaParidad = new JRadioButton("Paridad");
    private final JRadioButton opcionTipoApuestaColor = new JRadioButton("Color");

    private final JRadioButton opcionParidadPar = new JRadioButton("Par");
    private final JRadioButton opcionParidadImpar = new JRadioButton("Impar");

    private final JRadioButton opcionColorRojo = new JRadioButton("Rojo");
    private final JRadioButton opcionColorNegro = new JRadioButton("Negro");

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

        opcionTipoApuestaParidad.setSelected(true);
        opcionParidadImpar.setSelected(true);
        opcionColorNegro.setSelected(true);

        agregarFila("Selecciona el tipo de apuesta",0,opcionTipoApuestaParidad,opcionTipoApuestaColor);
        agregarFila("Selecciona la paridad de tu apuesta",1,opcionParidadImpar,opcionParidadPar);
        agregarFila("Selecciona el color de tu apuesta",2,opcionColorNegro,opcionColorRojo);
        agregarFila("Selecciona la cantidad a apostar",3,spinnerMonto);
        agregarFila("",4,btnGirar);
        agregarFila("Saldo", 5,textFieldBalance);
        agregarFila("Resultado de la ruleta",6,lblResultado);
        agregarFila("Salir de la ruleta",7,btnSalir);
        btnGirar.addActionListener(e -> girar());
        btnSalir.addActionListener(e -> irAVentanaMenu());

        opcionColorRojo.setEnabled(false);
        opcionColorNegro.setEnabled(false);
        textFieldBalance.setEditable(false);
        ActionListener saberTipoApuestaSelec = e ->
        {
            boolean esPar = opcionTipoApuestaParidad.isSelected();
            opcionParidadImpar.setEnabled(esPar);
            opcionParidadPar.setEnabled(esPar);

            opcionColorNegro.setEnabled(!esPar);
            opcionColorRojo.setEnabled(!esPar);

        };
        opcionTipoApuestaParidad.addActionListener(saberTipoApuestaSelec);
        opcionTipoApuestaColor.addActionListener(saberTipoApuestaSelec);
        mostrarBalanceTotal();
    }
    public void mostrarVentanaRuleta()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void agregarFila(String texto, int numeroFila,JRadioButton botonA, JRadioButton botonB)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);

        ButtonGroup grupoGenerico = new ButtonGroup(); // los hace exlcluyentes
        grupoGenerico.add(botonA);
        grupoGenerico.add(botonB);
        botonA.setBounds(POS_X_OPCION1,posicionY,ANCHO_OPCIONES,ALTO_FILA);
        botonB.setBounds(POS_X_OPCION2,posicionY,ANCHO_OPCIONES,ALTO_FILA);

        frame.add(etiqueta);
        frame.add(botonA);
        frame.add(botonB);
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
        char tipo = obtenerTipoDeApuesta();
        try
        {
            Resultado resultado = ruletaController.realizarApuesta(tipo, monto);
            mostrarResultado(resultado);
        }
        catch (IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Apuesta inválida", JOptionPane.WARNING_MESSAGE);
        }
        int numeroRuleta = Ruleta.girarRuleta();
        boolean acierto = Ruleta.evaluarResultado(numeroRuleta, tipo);
        int dineroModificado = Ruleta.modificadorGanarPerder(monto, acierto);
    }
    private char obtenerTipoDeApuesta()
    {
        char charRetorno = ' ';
        if (opcionTipoApuestaParidad.isSelected())
        {
            if (opcionParidadPar.isSelected())
            {
                charRetorno = 'P';
            }
            else
                charRetorno = 'I';
        }
        if (opcionTipoApuestaColor.isSelected())
        {
            if (opcionColorNegro.isSelected())
            {
                charRetorno = 'N';
            }
            else
                charRetorno = 'R';
        }
        return charRetorno;
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
        String colorRetornado = " ";
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
