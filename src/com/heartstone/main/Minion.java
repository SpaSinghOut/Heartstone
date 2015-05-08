package com.heartstone.main;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Util;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public enum Minion implements Card{
	WISP(1,1,1), //Battlecry: Silence a minion.
	LAVA_GOLEM(1,2,1), 
	BURNING_CRUSADER(2,1,3), //Battlecry: Deal 1 damage.
	DIREWOLF(3,2,2), //Battlecry: Give your other minions +1 Attack.
	LOST_SOUL(3,2,4), //Barrier
	SABRETOOTHTIGER(3,4,2),
	MYSTERIOUS_MAN(3,5,1),
	BANDIT(4,1,2), //50% chance to steal a card from your opponent's hand while attacking their hero.
	DROGON(8,9,7), //Legendary
	//Royal Class
	ROYAL_SEER(2,0,4), //Can see into opponent's hand.
	ROYAL_GUARD(4,1,5), //Taunt. Battlecry: Draw a card.
	ROYAL_KNIGHT(5,3,3), //Deathrattle: Summon three 1/1 Royal Footmen.
	ROYAL_GRUNT(7,7,3), //Haste. Bleed.
	//Divine Class
	DIVINE_PRIEST(8,2,8); //BARRIER. Battlecry: Give a friendly minion +2/+2. Heal all other minions for +1 at the end of each turn.
	//Elven class
	//Demon/Demonic/Dark class
	//Beast class
	//Mech class
	int mana;
	int damage;
	int health;
	VisibleObject face;
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
	@Override
	public void playCard() {
		switch(this){
		case BANDIT:
			break;
		case BURNING_CRUSADER:
			break;
		case DROGON:
			break;
		case DIREWOLF:
			break;
		case LAVA_GOLEM:
			break;
		case LOST_SOUL:
			break;
		case MYSTERIOUS_MAN:
			break;
		case SABRETOOTHTIGER:
			break;
		case WISP:
			break;
		case ROYAL_GUARD:
			break;
		case DIVINE_PRIEST:
			break;
		case ROYAL_GRUNT:
			break;
		case ROYAL_KNIGHT:
			break;
		case ROYAL_SEER:
			break;
		default:
			break;
		}
	}
	public void setFace(Engine engine, String fileType, String path){
		face = new VisibleObject(engine);
		face.setTexture(fileType, path);
		face.setWidth(120);
		face.setHeight(200);
		face.color = Util.Color.WHITE;
	}
	public void drawMe(Camera camera){
		try {
			face.drawMe(camera);
		} 
		catch (NullColorException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getManaCost() {
		return mana;
	}
	public int getHealth() {
		return health;
		//Fuck it     if(Card.gethealth(Minion.class).equals(Minion.Health))
	}
}
