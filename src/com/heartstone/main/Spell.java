package com.heartstone.main;

public enum Spell implements Card{
	PERIL(1),      //Destroy an enemy minion Barrier.
	ENLIGHTEN(1),  //View 1 card from your opponent's hand.
	CLEANSE(2),    //Cleanse a friendly minion of any curses.
	SILENCE(2),    //Silence a minion.
	HUSTLE(3),	   //Give a friendly minion Haste. 
	SAP(3),      //Sap health equal to the amount of friendly minions on the battlefield from your opponent's hero.
	JUGGERNAUT(4), //Give a friendly minion +6 Health. 
	RESURRECT(4),  //Resurrect a minion that died this turn and place it into the battlefield.
	THIEVES_GAMBIT(6), //Grant a friendly minion a 25% chance to deal triple damage.
	SHUFFLE(6),    //Shuffle your hand into your deck and draw a new hand.
	OBLITERATE(7), //Deal 4 damage to all enemy minions.
	OBEDIENCE(8),  //Take control of an enemy minion.
	OBLIVION(9),  //Take 8 damage. Deal 2 damage to your opponent every turn.
	DYING_BREATH(10); //Deals 6 damage to all enemies. (May only be played if your hero falls below 5 health)
	
	
	/*
	 * PASSIVE EFFECTS *
	BLEED:(Any minion hit by this effect loses 1 Health per turn)
	DEATHRATTLE:(Will do what we set the cards to do)
	ENDEAVOR:(50% chance to deal 2x damage)
	MANUEVER:(25% chance to dodge attacks)
	TAUNT:
	REVENGE:(When this minion is killed, deal damage equal to the attacking minion's Health.)
	BARRIER:(Gives a friendly minion a Barrier until it is broken)
	HASTE:(Attack the same turn this card was played)
	LEECH:(The amount of damage done by this card will be given to your hero as Health)
	FEARLESS:(This minion will automatically attack the strongest enemy minion every turn until dying)
	 */
	
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
		case HUSTLE:
			break;
		case JUGGERNAUT:
			break;
		case OBEDIENCE:
			break;
		case OBLITERATE:
			break;
		case SAP:
			break;
		case RESURRECT:
			break;
		case CLEANSE:
			break;
		case OBLIVION:
			break;
		case ENLIGHTEN:
			break;
		case THIEVES_GAMBIT:
			break;
		case PERIL:
			break;
		case SHUFFLE:
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

