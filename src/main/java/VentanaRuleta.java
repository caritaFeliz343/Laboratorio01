import javax.swing.*;

public class VentanaRuleta
{
    private final JFrame frame = new JFrame("Ruleta");
    public VentanaRuleta()
    {
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void mostrarVentanaRuleta()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
