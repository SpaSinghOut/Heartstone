package com.heartstone.main;

public class Hero {
	int health, mana;
	public Hero(int health) {
		this.health = health;
	}
	public int getMaxMana(){ 
		return 10;
	}
	public int turn() {
		int turn = 1;
		return mana += turn;
	}
}


