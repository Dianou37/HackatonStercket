package com.example.donjon.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	
	
	private int degat;
	private String image;
	
	
	public Arme() {
		Random dice = new Random();
		degat = dice.nextInt(MAX) + 20;
		
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
