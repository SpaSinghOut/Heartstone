package com.heartstone.main;

public class Card {
	int mana, damage, health;
	public Card(int mana, int damage, int health){
		this.mana = mana;
		this.damage = damage;
		this.health = health;
	}
	void attack(Card victim){
		damage(victim);
		victim.damage(this);
	}
	private void damage(Card victim){
		victim.health -= damage;
	}
}
