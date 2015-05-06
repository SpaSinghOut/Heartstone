package com.heartstone.main;

public enum Minion {
	lavaGolem(1,2,1),
	direWolf(3,3,3),
	burningCrusader(2,1,3),
	juggernaut(6,2,9),
	mysteriousMan(3,5,1),
	bandit(2,2,2),
	sabreToothTiger(3,4,2),
	wisp(1,1,1),
	darkAngel(8,9,7),
	lostSoul(2,2,4),;
	int mana, damage, health;
	Minion(int mana, int damage, int health){
		this.mana = mana;
		this.damage = damage;
		this.health = health;
	}
	void attack(Minion victim){
		damage(victim);
		victim.damage(this);
	}
	private void damage(Minion victim){
		victim.health -= damage;
	}
}
