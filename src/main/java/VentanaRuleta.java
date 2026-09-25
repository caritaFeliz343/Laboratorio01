import javax.swing.*;
import java.awt.*;

public class VentanaRuleta
{
    private final JFrame frame = new JFrame("Ruleta");
    private final JLabel  lblTipoApuesta = new JLabel("Seleccciona tu tipo de apuesta");
    private final JLabel  lblColor = new JLabel("Seleccciona el color de tu apuesta");
    private final JLabel  lblParidad = new JLabel("Seleccciona la paridad de tu apuesta");
    private final JRadioButton opcionTipoApuestaParidad = new JRadioButton("Paridad");
    private final JRadioButton opcionTipoApuestaColor = new JRadioButton("Color");

    public VentanaRuleta()
    {
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(lblTipoApuesta);
        frame.add(opcionTipoApuestaColor);
        frame.add(opcionTipoApuestaParidad);
        frame.add(lblColor);
        frame.add(lblParidad);


        opcionTipoApuestaColor.setSelected(true);

        ButtonGroup grupoTipoApuesta = new ButtonGroup();
        grupoTipoApuesta.add(opcionTipoApuestaColor);
        grupoTipoApuesta.add(opcionTipoApuestaParidad);

    }
    public void mostrarVentanaRuleta()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
