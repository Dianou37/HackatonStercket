package com.example.donjon.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Perso {
	
	public final int MAX = 80;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotNull
	@Size(min=2,max=35)
	private String name;
	private int hp;
	private int vigueur;
	private int agilite;
	private int intelligence;
	private int ruse;
	private int volonte;
	private int presence;
	
	public Perso() {
		Random dice = new Random();
		hp = dice.nextInt(MAX)+20;
		vigueur = dice.nextInt(10);
		agilite = dice.nextInt(10);
		intelligence = dice.nextInt(10);
		ruse = dice.nextInt(10);
		volonte = dice.nextInt(10);
		presence = dice.nextInt(10);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getVigueur() {
		return vigueur;
	}

	public void setVigueur(int vigueur) {
		this.vigueur = vigueur;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getRuse() {
		return ruse;
	}

	public void setRuse(int ruse) {
		this.ruse = ruse;
	}

	public int getVolonte() {
		return volonte;
	}

	public void setVolonte(int volonte) {
		this.volonte = volonte;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}
	
	
}
