package com.heartstone.main;

public enum Spell implements Card{
	JUGGERNAUT(4), //Give a minion +6 health.
	OBLITERATE(7), //Deal 4 damage to all enemy minions.
	HASTE(3),	   //Give a minion Haste. HASTE:(Attack the same turn this card was played)
	OBEDIENCE(8),  //Take control of an enemy minion.
	OBLIVION(9),   //Take 8 damage. Deal 2 damage to your opponent every turn.
	RESURRECT(5),  //Resurrect a minion that died this turn and place it into the battlefield.
	ENLIGHTEN(2);  //View 1 card from your opponent's hand.
	
	
	
	
    int mana;
    Minion target;
    Spell(int mana){
    	this.mana = mana;
    }
    Spell(int mana, Minion target){
    	this(mana);
    	this.target = target;
    }
	@Override
	public void playCard() {
		switch(this){
		case HASTE:
			break;
		case JUGGERNAUT:
			break;
		case OBEDIENCE:
			break;
		case OBLITERATE:
			break;
		default:
			break;
		
		}
		
	}
	@Override
	public int getManaCost() {
		return mana;
	}
}

