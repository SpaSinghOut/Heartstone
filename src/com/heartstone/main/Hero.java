package com.heartstone.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Util;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public class Hero extends VisibleObject{
	int health, mana, maxMana;
	String name;
	Scanner inputListener = new Scanner(System.in);
	public final static int maxMaxMana = 10;
	public static ArrayList<Hero> heroes = new ArrayList<Hero>();
	ArrayList<Card> deck = new ArrayList<Card>(), hand = new ArrayList<Card>(), field = new ArrayList<Card>();
	int fieldVerticalOffset;
	static Hero currentHero;
	public Hero(String name, Engine engine){
		super(engine);
		this.name = name;
		health = 30;
		heroes.add(this);
		createDeck();
		setWidth(120);
		setHeight(200);
		color = Util.Color.WHITE;
	}
	private void createDeck() {
		for(int i = 0; i < 30; i++)deck.add(Minion.values()[(int)(Math.random()*Minion.values().length)]);
	}
	public void turn() {
		currentHero = this;
		resetMana();
		playCard(drawCard());
		while(currentHero.equals(this));
	}
	private boolean listenForInput() {
		switch(inputListener.nextLine().toLowerCase()){
		case "end turn":case "endturn":
			System.out.println("The player " + name + " has ended their turn");
			return false;
		}
		return true;
	}
	private Card drawCard(){
		Card card = deck.get((int)(Math.random()*deck.size()));
		hand.add(card);
		System.out.println("The player " + name +" drew the card " + card.name());
		return card;
	}
	private void resetMana(){
		mana=++maxMana;
		System.out.println("The player " + name + " has " + mana + " mana");
	}
	void playCard(Card card){
		mana -= card.getManaCost();									// Subtracts the mana cost from the user's mana
		card.playCard();											// Tells the card that it has been played allowing it to prock special effects
		hand.remove(card);											// Removes the card from the hand
		if(card.getClass().equals(Minion.class)){					// If this is a minion type card
			field.add(card);										// Then add it to the field and initialize its graphics
			((Minion)card).setFace(engine, "JPG", "resources/" + ((Minion)card).toString().toLowerCase() + ".jpg");
		}
		for(int i = 0; i < field.size(); i++)						// Reconfigure Minion positions
			((Minion)field.get(i)).face.setLocation(350 + 150 * i, getLocation().y + fieldVerticalOffset);
	}
	public boolean drawMe(Camera camera) throws Util.NullColorException{
		for(Card c: field)
			((Minion)c).face.drawMe(camera);
		return super.drawMe(camera);
	}
}


