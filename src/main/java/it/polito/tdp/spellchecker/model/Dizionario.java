package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dizionario {
	
	private List<String> parole = new LinkedList<String>();
	
	public void scegliDizionario(String s) {
		try {
			if(s.equals("English")) {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String parola;
				while ((parola = br.readLine()) != null) {
					parole.add(parola);
				}
				br.close();
			} else {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String parola;
				while ((parola = br.readLine()) != null) {
					parole.add(parola);
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println("errore nella lettura file");
			e.printStackTrace();
		}		
	}
	
	public boolean esiste(String s) {
		if (parole.contains(s)) {
			return true;
		} else {
			return false;
		}
	}

}
