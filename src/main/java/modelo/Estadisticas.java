package modelo;

import java.util.List;

public class Estadisticas {

	private final int totalJugadas;
	private final int victorias;
	private final double porcentajeVictorias;
	private int rachaMaxima;
	private TipoApuesta tipoMasJugado;

	public Estadisticas(List<Resultado> resultados) {
		this.totalJugadas = resultados.size();
		this.victorias = contarVictorias(resultados);
		this.porcentajeVictorias = calcularPorcentajeVictorias();
	}

	public int getTotalJugadas() {
		return this.totalJugadas;
	}

	public int getVictorias() {
		return this.victorias;
	}

	public double getPorcentajeVictorias() {
		return this.porcentajeVictorias;
	}

	public int getRachaMaxima() {
		return this.rachaMaxima;
	}

	public TipoApuesta getTipoMasJugado() {
		return this.tipoMasJugado;
	}

	private int contarVictorias(List<Resultado> resultados) {
		int contador = 0;
		for (Resultado resultado : resultados) {
			if (resultado.getEsAcierto()) {
				contador++;
			}
		}
		return contador;
	}

	private double calcularPorcentajeVictorias() {
		if (totalJugadas == 0) {
			return 0.0;
		}
		return (victorias * 100.0) / totalJugadas;
	}
}