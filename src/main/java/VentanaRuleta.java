import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRuleta
{
    private static final int ALTO_FILA = 25;
    private static final int ANCHO_OPCIONES = 80;
    private static final int ANCHO_TEXTO = 220;
    private static final int POS_Y_TIPO_APUESTA = 20;
    private static final int POS_Y_PARIDAD_APUESTA = 50;
    private static final int POS_Y_COLOR_APUESTA = 80;
    private static final int POS_X_TEXTO = 20;
    private static final int POS_X_OPCION1 = 320;
    private static final int POS_X_OPCION2 = 420;


    private final JFrame frame = new JFrame("Ruleta");

    private final JLabel  lblTipoApuesta = new JLabel("Seleccciona tu tipo de apuesta");
    private final JLabel  lblColor = new JLabel("Seleccciona el color de tu apuesta");
    private final JLabel  lblParidad = new JLabel("Seleccciona la paridad de tu apuesta");

    private final JRadioButton opcionTipoApuestaParidad = new JRadioButton("Paridad");
    private final JRadioButton opcionTipoApuestaColor = new JRadioButton("Color");

    private final JRadioButton opcionParidadPar = new JRadioButton("Par");
    private final JRadioButton opcionParidadImpar = new JRadioButton("Impar");

    private final JRadioButton opcionColorRojo = new JRadioButton("Rojo");
    private final JRadioButton opcionColorNegro = new JRadioButton("Negro");

    public VentanaRuleta()
    {
        frame.setSize(640,480);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        opcionTipoApuestaParidad.setSelected(true);
        opcionParidadImpar.setSelected(true);

        ButtonGroup grupoTipoApuesta = new ButtonGroup(); //hace que sean exlcuyentes
        grupoTipoApuesta.add(opcionTipoApuestaParidad);
        grupoTipoApuesta.add(opcionTipoApuestaColor);
        lblTipoApuesta.setBounds(POS_X_TEXTO,POS_Y_TIPO_APUESTA,ANCHO_TEXTO,ALTO_FILA);
        opcionTipoApuestaParidad.setBounds(POS_X_OPCION1,POS_Y_TIPO_APUESTA,ANCHO_OPCIONES,ALTO_FILA);
        opcionTipoApuestaColor.setBounds(POS_X_OPCION2,POS_Y_TIPO_APUESTA,ANCHO_OPCIONES,ALTO_FILA);

        ButtonGroup grupoParidad = new ButtonGroup();
        grupoParidad.add(opcionParidadImpar);
        grupoParidad.add(opcionParidadPar);
        lblParidad.setBounds(POS_X_TEXTO,POS_Y_PARIDAD_APUESTA,ANCHO_TEXTO,ALTO_FILA);
        opcionParidadImpar.setBounds(POS_X_OPCION1,POS_Y_PARIDAD_APUESTA,ANCHO_OPCIONES, ALTO_FILA);
        opcionParidadPar.setBounds(POS_X_OPCION2,POS_Y_PARIDAD_APUESTA,ANCHO_OPCIONES,ALTO_FILA);

        ButtonGroup grupoColor = new ButtonGroup();
        grupoColor.add(opcionColorNegro);
        grupoColor.add(opcionColorRojo);
        lblColor.setBounds(POS_X_TEXTO,POS_Y_COLOR_APUESTA,ANCHO_TEXTO,ALTO_FILA);
        opcionColorNegro.setBounds(POS_X_OPCION1,POS_Y_COLOR_APUESTA,ANCHO_OPCIONES,ALTO_FILA);
        opcionColorRojo.setBounds(POS_X_OPCION2,POS_Y_COLOR_APUESTA,ANCHO_OPCIONES,ALTO_FILA);

        opcionColorRojo.setEnabled(false);
        opcionColorNegro.setEnabled(false);
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

        frame.add(lblTipoApuesta);
        frame.add(opcionTipoApuestaParidad);
        frame.add(opcionTipoApuestaColor);
        frame.add(lblParidad);
        frame.add(opcionParidadImpar);
        frame.add(opcionParidadPar);
        frame.add(lblColor);
        frame.add(opcionColorNegro);
        frame.add(opcionColorRojo);
    }
    public void mostrarVentanaRuleta()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
