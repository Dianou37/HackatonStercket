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
public class Monstre {
	
	public final int MAX = 100;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotNull
	@Size(min=2,max=30)
	private String name;
	@NotNull
	@Min(0)
	@Max(100)
	private int hp;
	@NotNull
	@Min(0)
	@Max(100)
	private int maxHp;
	@NotNull
	@Min(0)
	@Max(100)
	private int attack;
	
	public Monstre() {
		Random dice = new Random();
		attack = dice.nextInt(MAX);
		hp = dice.nextInt(MAX);
		maxHp = hp;
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
	
	
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
}
