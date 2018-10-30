package com.gympass.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gympass.domain.Corrida;
import com.gympass.domain.Voltas;

public class Estatisticas {

	private Map<String, List<Voltas>> lista = new LerArquivo().lerArquivo();
	private int totalVoltas = 4;

	public List<Corrida> classificacaoGeral() {
		List<Corrida> corridasOrdenada = new ArrayList<Corrida>();
		List<Corrida> corridasGeral = getListaCorridaPiloto();
		ArrayList<Corrida> corridas = new ArrayList<Corrida>();

		int voltasCorrida = totalVoltas;
		while (!corridasGeral.isEmpty()) {

			for (int i = corridasGeral.size(); i > 0; i--) {
				if (corridasGeral.get(i - 1).getVoltas().size() == voltasCorrida) {
					corridas.add(corridasGeral.get(i - 1));
					corridasGeral.remove(corridasGeral.get(i - 1));
				}

			}
			corridasOrdenada.addAll(quickSort(corridas));
			corridas.clear();
			voltasCorrida--;

		}

		return corridasOrdenada;

	}

	protected ArrayList<Corrida> quickSort(ArrayList<Corrida> corridas) {
		if (corridas.size() <= 1) {
			return corridas;
		}

		ArrayList<Corrida> sorted = new ArrayList<Corrida>();
		ArrayList<Corrida> lesser = new ArrayList<Corrida>();
		ArrayList<Corrida> greater = new ArrayList<Corrida>();

		Corrida pivot = corridas.get(corridas.size() - 1);

		for (int i = 0; i < corridas.size() - 1; i++) {

			if (corridas.get(i).compareTo(pivot) < 0) {
				lesser.add(corridas.get(i));
			} else {
				greater.add(corridas.get(i));
			}
		}

		lesser = quickSort(lesser);
		greater = quickSort(greater);

		lesser.add(pivot);
		lesser.addAll(greater);
		sorted = lesser;

		return sorted;
	}

	public List<Corrida> getListaCorridaPiloto() {

		List<Corrida> corridas = new ArrayList<Corrida>();

		for (Map.Entry<String, List<Voltas>> entry : lista.entrySet()) {

			List<Voltas> voltas = entry.getValue();
			Corrida corrida = new Corrida();

			Calendar calendario = new Calendar.Builder().setTimeOfDay(0, 0, 0).build();

			for (int i = 0; i < voltas.size(); i++) {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(voltas.get(i).getTempoVolta());

				Date addTempo = calendar.getTime();

				SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S");
				String sData = sdf.format(addTempo);
				int minutos = Integer.parseInt(sData.substring(0, 2));
				int segundos = Integer.parseInt(sData.substring(3, 5));
				int milli = Integer.parseInt(sData.substring(6));

				somarMinutosSegundosMilesimos(calendario, minutos, segundos, milli);

				corrida.setVelocidadeMedia(corrida.getVelocidadeMedia() + voltas.get(i).getVelocMedia());

			}
			corrida.setPiloto(voltas.get(0).getPiloto());
			corrida.setVoltas(voltas);
			corrida.setTempoCorrida(calendario.getTime());
			corridas.add(corrida);
		}

		return corridas;

	}

	public Date somarMinutosSegundosMilesimos(Calendar calendario, int minutos, int segundos, int milissegundos) {
		calendario.add(Calendar.MINUTE, minutos);
		calendario.add(Calendar.SECOND, segundos);
		calendario.add(Calendar.MILLISECOND, milissegundos);
		return calendario.getTime();
	}

	public List<Voltas> getListaMelhorVoltaPiloto() {
		List<Voltas> melhoresVoltas = new ArrayList<Voltas>();

		for (Map.Entry<String, List<Voltas>> entry : lista.entrySet()) {

			List<Voltas> voltas = entry.getValue();
			Voltas melhorVolta = voltas.get(0);

			for (int i = 1; i < voltas.size(); i++) {

				if (voltas.get(i).getTempoVolta().before(melhorVolta.getTempoVolta())) {
					melhorVolta = voltas.get(i);
				}

			}
			melhoresVoltas.add(melhorVolta);
		}

		return melhoresVoltas;

	}

	public Voltas getListaMelhorVoltaCorrida() {

		List<Voltas> voltas = getListaMelhorVoltaPiloto();
		Voltas melhorVolta = voltas.get(0);

		for (int i = 1; i < voltas.size(); i++) {

			if (voltas.get(i).getTempoVolta().before(melhorVolta.getTempoVolta())) {
				melhorVolta = voltas.get(i);
			}

		}

		return melhorVolta;

	}

}
