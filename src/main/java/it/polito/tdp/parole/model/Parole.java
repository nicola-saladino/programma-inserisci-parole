package it.polito.tdp.parole.model;

import java.util.List;

import java.util.ArrayList;

import java.util.Collections;


public class Parole{
		
	private List<String> elenco;
	
	public Parole() {
		elenco = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		elenco.add(p);
	}
	
	public List<String> getElenco() {
		List<String> elencoOrdinato = new ArrayList<String>(elenco);
		Collections.sort(elencoOrdinato);
		return elencoOrdinato;
		
	}
	
	public void reset() {
		elenco.clear();
	}
	
	public void cancellaParola(String p) {
	    elenco.remove(p);
	}

}
