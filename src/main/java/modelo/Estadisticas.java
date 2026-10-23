package modelo;

import java.util.List;

public class Estadisticas {

	private final int totalJugadas;
	private final int victorias;
	private final double porcentajeVictorias;
	private final int rachaMaxima;
	private final TipoApuesta tipoMasJugado;

	public Estadisticas(List<Resultado> resultados) {
		this.totalJugadas = resultados.size();
		this.victorias = contarVictorias(resultados);
		this.porcentajeVictorias = calcularPorcentajeVictorias();
		this.rachaMaxima = calcularRachaMaxima(resultados);
		this.tipoMasJugado = calcularTipoMasJugado(resultados);
	}

	public int getTotalJugadas()
	{
		return this.totalJugadas;
	}

	public int getVictorias()
	{
		return this.victorias;
	}

	public double getPorcentajeVictorias()
	{
		return this.porcentajeVictorias;
	}

	public int getRachaMaxima()
	{
		return this.rachaMaxima;
	}

	public TipoApuesta getTipoMasJugado()
	{
		return this.tipoMasJugado;
	}

	private int contarVictorias(List<Resultado> resultados)
	{
		int contador = 0;
		for (Resultado resultado : resultados)
		{
			if (resultado.getEsAcierto())
			{
				contador++;
			}
		}
		return contador;
	}

	private double calcularPorcentajeVictorias()
	{
		if (totalJugadas == 0)
		{
			return 0.0;
		}
		return (victorias * 100.0) / totalJugadas;
	}

	private int calcularRachaMaxima(List<Resultado> resultados)
	{
		int rachaActual = 0;
		int mejorRacha = 0;
		for (Resultado resultado : resultados)
		{
			if (resultado.getEsAcierto())
			{
				rachaActual++;
				if (rachaActual > mejorRacha)
				{
					mejorRacha = rachaActual;
				}
			}
			else
			{
				rachaActual = 0;
			}
		}
		return mejorRacha;
	}

	private TipoApuesta calcularTipoMasJugado(List<Resultado> resultados)
	{
		if (resultados.isEmpty())
		{
			return null;
		}
		TipoApuesta[] tiposApuestas = TipoApuesta.values();
		int[] contadorPorTipo = new int[tiposApuestas.length];
		for (Resultado resultado : resultados)
		{
			contadorPorTipo[resultado.getTipo().ordinal()]++; // funciona haciendo [0,0,0,0], donde cada valor es la cantidad de cada enum
			// Por ejemplo, si se apuesta un rojo, y despues un par, quedaria algo como [1,0,1,0]
		}
		int indiceValorMayorConteo = 0;
		for (int i = 1; i < contadorPorTipo.length; i++)
		{
			if (contadorPorTipo[i] > contadorPorTipo[indiceValorMayorConteo])  // Basicamente si el valor del contador [0,0,0,0] es mayor en i o en 0
			{
				indiceValorMayorConteo = i;
			}
		}
		return tiposApuestas[indiceValorMayorConteo];
	}
}