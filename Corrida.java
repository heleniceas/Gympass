package com.gympass.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Corrida {
	private int posicao;
	private Piloto piloto;
	
	private double  velocidadeMedia;
	private  Date tempoCorrida;
	private  List<Voltas> voltas;
	
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public Date getTempoCorrida() {
		return tempoCorrida;
	}
	public String getTempoCorridaFormatado() {
		SimpleDateFormat sdf= new SimpleDateFormat("mm:ss:S");
		 String sData = sdf.format(tempoCorrida);
		return sData;
	}
	public void setTempoCorrida(Date tempoCorrida) {
		this.tempoCorrida = tempoCorrida;
	}
	public List<Voltas> getVoltas() {
		return voltas;
	}
	public void setVoltas(List<Voltas> voltas) {
		this.voltas = voltas;
	}
	public int compareTo(Corrida pivot) {
		if (this.tempoCorrida.before( pivot.tempoCorrida)) {
            return -1;
        }
        if (this.tempoCorrida.after(pivot.tempoCorrida)) {
            return 1;
        }
	return 0;
	}
	
	
	
	
	
	
	

}
