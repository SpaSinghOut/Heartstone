package com.heartstone.main;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public enum Minion implements Card{
	LAVAGOLEM(1,2,1),
	DIREWOLF(3,3,3),
	BURNINGCRUSADER(2,1,3),
	JUGGERNAUT(6,2,9),
	MYSTERIOUSMAN(3,5,1),
	BANDIT(2,2,2),
	SABRETOOTHTIGER(3,4,2),
	WISP(1,1,1),
	DARKANGEL(8,9,7),
	LOSTSOUL(2,2,4),;
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
		case JUGGERNAUT:
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
		default:
			break;
		
		}
	}
	public void setFace(Engine engine, String fileType, String path){
		face = new VisibleObject(engine);
		face.setTexture(fileType, path);
		face.setWidth(120);
		face.setHeight(200);
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
