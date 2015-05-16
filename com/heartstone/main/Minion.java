package com.heartstone.main;

import org.newdawn.slick.Color;
import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Location;
import com.spartanlaboratories.engine.structure.Util;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public class Minion implements Card{
	enum Preset{
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
		int health, damage;
		Preset(int mana, int health, int damage){
			this.mana = mana;
			this.health = health;
			this.damage = damage;
		}
	}
	int mana;
	int damage;
	int health;
	Preset preset;
	VisibleObject face;
	Hero owner;
	Minion(Preset preset){
		this.preset = preset;
		mana = preset.mana;
		health = preset.health;
		damage = preset.damage;
	}
	@Override
	public void playCard() {
		switch(preset){
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
	@Override
	public int getManaCost() {
		return mana;
	}
	public int getHealth() {
		return health;
	}
	@Override
	public String name() {
		return preset.name().toLowerCase();
	}
	void attack(Minion victim){
		damage(victim);
		victim.damage(this);
	}
	public void setFace(Engine engine, String fileType, String path){
		face = new VisibleObject(engine);
		face.setTexture(fileType, path);
		face.setWidth(90);
		face.setHeight(150);
		face.color = Util.Color.WHITE;
	}
	public void drawMe(Camera camera){
		// Draws the minion's portrait
		try {
			face.drawMe(camera);
		} catch (NullColorException e) {
			e.printStackTrace();
		}
		
		/* Abandoned code for drawing the health of a minion. Probably will not come back to it. Spartak.
		final int size = 32;
		BufferedImage health = new BufferedImage(size,size, BufferedImage.TYPE_INT_RGB);
		byte[] data = new byte[(int) (health.getType() * Math.pow(size, 2))];
		Graphics2D g = health.createGraphics();
		g.drawString(String.valueOf(this.health), 0, 0);
		health.getAlphaRaster().getDataElements(0, 0, size, size, data);
		ByteBuffer b = ByteBuffer.allocate(data.length);
		b.get(data);
		b.rewind();
		GL11.g
		*/
		
		// Draws the minion's health value
		drawStat("health", camera);
		drawStat("damage", camera);
		drawStat("mana", camera);
	}
	
	private synchronized void changeHealth(int netChange){
		health += netChange;
		if(health <= 0){
			owner.field.remove(this);
			owner.graveyard.add(this);
		}
	}
	private void drawStat(String stat, Camera camera){
		double xMod = 0, yMod = 0, value = 0;
		Color color = Color.yellow;;
		
		// Creation of the Font with which the health will be drawn
		Font font;
		font = new Font("Arial", Font.BOLD, 32);
		TrueTypeFont f = new TrueTypeFont(font, false);
		
		switch(stat){
		case "damage":
			xMod = -.5;
			yMod = 0.34;
			value = damage;
			color = Color.yellow;
			break;
		case "health":
			xMod = 1 / 2.8;
			yMod = 1 / 2.95;
			value = health;
			color = Color.red;
			break;
		case "mana":
			xMod = 1 / 2.8;
			yMod =-1 / 2.95;
			value = mana;
			color = Color.blue;
			break;
		default: throw new IllegalArgumentException();
		}
		
		// Setting the location at which the health will be drawn
		Location drawLocation = new Location(face.getLocation().getLocationOnScreen(camera));
		drawLocation.x += (int)(face.getWidth() * xMod);
		drawLocation.y += (int)(face.getHeight() * yMod);
		
		// Actually showing the health of this minion
		f.drawString((float)drawLocation.x, (float)drawLocation.y, String.valueOf((int)value), color);
	}
	private void damage(Minion victim){
		victim.changeHealth(-damage);
	}
}
