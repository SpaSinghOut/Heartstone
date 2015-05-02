package com.heartstone.main;

public class Card {
	int health, damage;
	public Card(int health, int damage){
		this.health = health;
		this.damage = damage;
	}
	void attack(Card victim){
		damage(victim);
		victim.damage(this);
	}
	private void damage(Card victim){
		victim.health -= damage;
	}
}
