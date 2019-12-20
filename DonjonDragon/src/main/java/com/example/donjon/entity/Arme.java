package com.example.donjon.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Arme {
	
	final static int MAX = 81;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	private String image;

	
	private int durabilite;
	@Column(name="prec")
	private int precision;
	private int degat;
	private int portee;
	

	public Arme() {
		Random dice = new Random();
		degat = dice.nextInt(MAX) + 20;
		durabilite = dice.nextInt(16) + 5;
		precision = dice.nextInt(16)  +5;
		portee =  dice.nextInt(10)  +1;
		image = "https://www.boutique-epees.fr/18418-large_default/officiel-axe-ragnar-lothbrok-serie-vikings.jpg";
	}
	
	public int getDurabilite() {
		return durabilite;
	}
	
	public int getPrecision() {
		return precision;
	}
	
	public int getPortee() {
		return portee;
	}
	public void setDurabilite(int durabilite) {
		this.durabilite = durabilite;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public void setPortee(int portee) {
		this.portee = portee;
	}
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getDegat() {
		return degat;
	}
	public String getImage() {
		return image;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
