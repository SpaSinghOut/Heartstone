package com.heartstone.main;

public enum Spell implements Card{
	
	ENLIGHTEN(1),  //View 1 card from your opponent's hand.
	HASTE(3),	   //Give a friendly minion HASTE. 
	JUGGERNAUT(4), //Give a friendly minion +6 health.
	LEECH(4),      //Give a friendly minion LEECH. 
	RESURRECT(4),  //Resurrect a minion that died this turn and place it into the battlefield.
	CLEANSE(4),    //Return a minion to its original state.
	OBLITERATE(7), //Deal 4 damage to all enemy minions.
	OBEDIENCE(8),  //Take control of an enemy minion.
	OBLIVION(9);   //Take 8 damage. Deal 2 damage to your opponent every turn.
	
	//HASTE:(Attack the same turn this card was played)
	//LEECH:(The amount of damage done by this card will be given to your hero as health)

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
		case LEECH:
			break;
		case RESURRECT:
			break;
		case CLEANSE:
			break;
		case OBLIVION:
			break;
		case ENLIGHTEN:
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

