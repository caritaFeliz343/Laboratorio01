package vista;

import controlador.ResultadoController;
import controlador.RuletaController;
import controlador.SessionController;
import modelo.Estadisticas;

import javax.swing.*;

public class VentanaEstadisticas
{
    private final SessionController sesion;
    private final RuletaController ruletaController;
    private final ResultadoController resultadoController;
    private final Estadisticas estadisticas;
    private final int POS_X_INICIAL = 20;
    private final int POS_Y_BOTON = 380;
    private final int ANCHO_BOTON = 100;
    private final int ALTURA_BOTON = 50;
    private final int POS_Y_INICIAL = 20;
    private final int SEPARACION_Y = 30;
    private final int POS_X_TEXTO = 200;
    private final int ANCHO_TEXTO = 220;
    private final int ALTO_FILA = 25;

    private final JLabel lblTotalJugadas = new JLabel("");
    private final JLabel lblVictorias = new JLabel("");
    private final JLabel lblPorcentajeVictorias = new JLabel("");
    private final JLabel lblRachaMax = new JLabel("");
    private final JLabel lblTipoMasJugado = new JLabel("");

    private final JButton btnVolver = new JButton("Volver");

    private final JFrame frame = new JFrame("Estadisticas - Casino Black Cat");

    public VentanaEstadisticas(SessionController sesion, RuletaController ruletaController, ResultadoController resultadoController)
    {
        this.sesion = sesion;
        this.ruletaController = ruletaController;
        this.resultadoController = resultadoController;
        this.estadisticas = new Estadisticas(sesion.getUsuarioActual().getHistorialResultados());

        frame.setSize(640, 480);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnVolver.setBounds(POS_X_INICIAL, POS_Y_BOTON, ANCHO_BOTON, ALTURA_BOTON);
        agregarFila("Jugadas totales", 0, lblTotalJugadas);
        agregarFila("Victorias", 1, lblVictorias);
        agregarFila("Porcentaje Victorias", 2, lblPorcentajeVictorias);
        agregarFila("Racha maxima", 3, lblRachaMax);
        agregarFila("Tipo mas jugado", 4, lblTipoMasJugado);
        mostrarTodo();

        frame.add(btnVolver);
        btnVolver.addActionListener(e -> regresarMenu());

    }
    private void agregarFila(String texto, int numeroFila, JLabel lblFila)
    {
        int posicionY = numeroFila * SEPARACION_Y + POS_Y_INICIAL;
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(POS_X_INICIAL,posicionY,ANCHO_TEXTO,ALTO_FILA);

        lblFila.setBounds(POS_X_TEXTO,posicionY,ANCHO_TEXTO,ALTO_FILA);
        frame.add(etiqueta);
        frame.add(lblFila);
    }

    private void mostrarTotalJugadas()
    {
        lblTotalJugadas.setText(String.valueOf(estadisticas.getTotalJugadas()));
    }

    private void mostrarVictorias()
    {
        lblVictorias.setText(String.valueOf(estadisticas.getVictorias()));
    }

    private void mostrarPorcentajeVictorias()
    {
        lblPorcentajeVictorias.setText(String.valueOf(estadisticas.getPorcentajeVictorias()));
    }

    private void mostrarRachaMaxima()
    {
        lblRachaMax.setText(String.valueOf(estadisticas.getRachaMaxima()));
    }

    private void mostrarTipoMasJugado()
    {
        lblTipoMasJugado.setText(String.valueOf(estadisticas.getTipoMasJugado()));
    }
    private void mostrarTodo()
    {
        mostrarTotalJugadas();
        mostrarVictorias();
        mostrarPorcentajeVictorias();
        mostrarRachaMaxima();
        mostrarTipoMasJugado();
    }
    public void mostrarVentanaEstadisticas()
    {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void regresarMenu()
    {
        frame.dispose();
        VentanaMenu ventanaMenu = new VentanaMenu(sesion, ruletaController, resultadoController);
        ventanaMenu.mostrarVentana();
    }
}
