package com.gympass.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gympass.domain.Piloto;
import com.gympass.domain.Voltas;

public class LerArquivo {

	private static final String FILENAME = "C:\\Users\\Helenice\\Documents\\LogGympass.txt";

	public Map<String, List<Voltas>> lerArquivo() {
		BufferedReader br = null;
		FileReader fr = null;
		Map<String, List<Voltas>> mapa = new HashMap<String, List<Voltas>>();

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String line;

			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				if (("0123456789").contains(line.substring(0, 1))) {

					String[] campos = line.split("\\s+");

					if (campos.length == 7) {
						int i = 0;
						String hora = campos[i++];
						String pilotoNumero = campos[i++];
						i++;
						String pilotoNome = campos[i++];
						String voltaNr = campos[i++];
						String voltaTempo = campos[i++];
						String velocidadeMedia = campos[i++];

						Piloto piloto = new Piloto();
						piloto.setCodigo(pilotoNumero);
						piloto.setNome(pilotoNome);

						Voltas voltaCorrida = new Voltas();
						voltaCorrida.setHoraCorrida(hora);
						voltaCorrida.setNumeroVolta(voltaNr);

						voltaCorrida.setTempoVolta(voltaTempo);
						voltaCorrida.setVelocMedia(velocidadeMedia);
						voltaCorrida.setPiloto(piloto);

						if (mapa.isEmpty() || mapa.get(pilotoNumero) == null) {
							List<Voltas> corrida = new ArrayList<>();
							corrida.add(voltaCorrida);
							mapa.put(pilotoNumero, corrida);
						} else {
							mapa.get(pilotoNumero).add(voltaCorrida);
						}

					}

				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		return mapa;
	}
}
