package com.heartstone.main;

public enum Spell {
	JUGGERNAUT(4), //Give a minion +6 health.
	OBLITERATE(7), //Deal 4 damage to all enemy minions.
	HASTE(3),	   //Give a minion Haste. HASTE:(Attack the same turn this card was played)
	OBEDIENCE(8);  //Take control of an enemy minion.
	
    int mana;
    Spell(int mana){
    this.mana = mana;
    }
}

