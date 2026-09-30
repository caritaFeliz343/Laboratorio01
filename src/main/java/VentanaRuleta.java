import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRuleta
{
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        opcionTipoApuestaParidad.setSelected(true);
        opcionParidadImpar.setSelected(true);

        ButtonGroup grupoTipoApuesta = new ButtonGroup(); //hace que sean exlcuyentes
        grupoTipoApuesta.add(opcionTipoApuestaParidad);
        grupoTipoApuesta.add(opcionTipoApuestaColor);
        lblTipoApuesta.setBounds(20,20,180,25);
        opcionTipoApuestaParidad.setBounds(320,20,80,25);
        opcionTipoApuestaColor.setBounds(420,20,80,25);

        ButtonGroup grupoParidad = new ButtonGroup();
        grupoParidad.add(opcionParidadImpar);
        grupoParidad.add(opcionParidadPar);
        lblParidad.setBounds(20,50,220,25);
        opcionParidadImpar.setBounds(320,50,80,25);
        opcionParidadPar.setBounds(420,50,80,25);

        ButtonGroup grupoColor = new ButtonGroup();
        grupoColor.add(opcionColorNegro);
        grupoColor.add(opcionColorRojo);
        lblColor.setBounds(20,80,220,25);
        opcionColorNegro.setBounds(320,80,80,25);
        opcionColorRojo.setBounds(420,80,80,25);

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
