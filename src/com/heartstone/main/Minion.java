package com.heartstone.main;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Util;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public enum Minion implements Card{
	WISP(1,1,1), //Battlecry: Silence a minion.
	LAVAGOLEM(1,2,1), 
	ROYAL_GUARD(4,1,5), //Taunt. Battlecry: Draw a card.
	BURNINGCRUSADER(2,1,3), //Battlecry: Deal 1 damage.
	DIREWOLF(3,2,2), //Battlecry: Give your other minions +1 Attack.
	LOSTSOUL(3,2,4), //Barrier
	SABRETOOTHTIGER(3,4,2),
	MYSTERIOUSMAN(3,5,1),
	BANDIT(4,1,2), //50% chance to steal a card from your opponent's hand while attacking their hero.
	ROYAL_PRIEST(8,2,8), //BARRIER. Battlecry: Give a friendly minion +2/+2. Heal all other minions for +1 at the end of each turn.
	DARKANGEL(8,9,7);
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
		case BURNINGCRUSADER:
			break;
		case DARKANGEL:
			break;
		case DIREWOLF:
			break;
		case LAVAGOLEM:
			break;
		case LOSTSOUL:
			break;
		case MYSTERIOUSMAN:
			break;
		case SABRETOOTHTIGER:
			break;
		case WISP:
			break;
		case ROYAL_GUARD:
			break;
		case ROYAL_PRIEST:
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
		} catch (NullColorException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int getManaCost() {
		return mana;
	}
}
