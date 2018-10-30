package com.gympass.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Voltas implements Comparable {

	private int numeroVolta;

	private Date horaCorrida;

	private Date tempoVolta;

	private Double velocMedia;

	private Piloto piloto;

	public int getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(String numeroVolta) {
		try {
			this.numeroVolta = Integer.parseInt(numeroVolta);
		} catch (Exception e) {
			System.out.println("Erro ao converter a numero de volta" + numeroVolta);
			e.printStackTrace();
		}
	}

	public Date getHoraCorrida() {
		return horaCorrida;
	}

	public void setHoraCorrida(String horaCorrida) {
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		try {
			this.horaCorrida = (Date) formatter.parse(horaCorrida);
		} catch (ParseException e) {
			System.out.println("Erro ao converter a hora da Corrida" + horaCorrida);
			e.printStackTrace();
		}

	}

	public Date getTempoVolta() {
		return tempoVolta;
	}

	public String getTempoVoltaFormatado() {
		DateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
		String sData = formatter.format(tempoVolta);
		return sData;
	}

	public void setTempoVolta(String tempoVolta) {
		DateFormat formatter = new SimpleDateFormat("mm:ss.SSS");
		try {
			this.tempoVolta = (Date) formatter.parse(tempoVolta);
		} catch (ParseException e) {
			System.out.println("Erro ao converter a hora da Corrida" + tempoVolta);
			e.printStackTrace();
		}
	}

	public Double getVelocMedia() {
		return velocMedia;
	}

	public void setVelocMedia(String velocMedia) {
		velocMedia = velocMedia.replace(",", ".");
		this.velocMedia = Double.parseDouble(velocMedia);
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public int compareTo(Object o) {
		if (this.numeroVolta < ((Voltas) o).numeroVolta) {
			return -1;
		}
		if (this.numeroVolta > ((Voltas) o).numeroVolta) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Corrida [numeroVolta=" + numeroVolta + ", horaCorrida=" + horaCorrida + ", tempoVolta=" + tempoVolta
				+ ", velocMedia=" + velocMedia + ", piloto=" + piloto + ", getNumeroVolta()=" + getNumeroVolta()
				+ ", getHoraCorrida()=" + getHoraCorrida() + ", getTempoVolta()=" + getTempoVolta()
				+ ", getVelocMedia()=" + getVelocMedia() + ", getPiloto()=" + getPiloto() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
