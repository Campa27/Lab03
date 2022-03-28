package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	public boolean isCorretta() {
		return corretta;
	}
}
