package com.heartstone.main;

public enum Spell {
	JUGGERNAUT(4), //Give a minion +6 health.
	OBLITERATE(7), //Deal 4 damage to all enemy minions.
	HASTE(3),	   //Give a minion Haste. HASTE:(Attack the same turn this card was played)
	OBEDIENCE(8),  //Take control of an enemy minion.
	OBLIVION(9),   //Take 8 damage. Deal 2 damage to your opponent every turn.
	RESURRECT(4),  //Place a random dead minion in your hand.
	PURGATORY(10); //Your opponent is unable to attack for 2 turns.
    int mana;
    Spell(int mana){
    this.mana = mana;
    }
}

