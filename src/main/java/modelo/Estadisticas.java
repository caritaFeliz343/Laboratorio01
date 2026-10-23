package modelo;

import java.util.List;

public class Estadisticas {

	private TipoApuesta tipoMasJugado;
	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;

	public Estadisticas(List<Resultado> resultados) {
		// TODO - implement Estadisticas.Estadisticas
		throw new UnsupportedOperationException();
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
		// TODO - implement Estadisticas.getTipoMasJugado
		throw new UnsupportedOperationException();
	}


}