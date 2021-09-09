package com.example.demo.model;

import java.math.BigDecimal;

public class Empleat {
	
	private int id;
	private String nom;
	private Treball treball;
	private BigDecimal sou;

	public Empleat(int id, String nom, Treball treball) {
		this.id = id;
		this.nom = nom;
		this.treball = treball;
		this.sou = treball.getSou();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Treball getTreball() {
		return treball;
	}

	public void setTreball(Treball treball) {
		this.treball = treball;
	}
	
	public BigDecimal getSou() {
		return sou;
	}

	public void setSou(BigDecimal sou) {
		this.sou = sou;
	}

}
