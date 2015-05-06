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
	public Hero(String name, Engine engine){
		super(engine);
		this.name = name;
		health = 30;
		heroes.add(this);
		createDeck();
		setWidth(120);
		setHeight(200);
	}
	private void createDeck() {
		for(int i = 0; i < 30; i++)deck.add(Minion.values()[(int)(Math.random()*Minion.values().length)]);
	}
	public void turn() {
		resetMana();
		playCard(drawCard());
		while(listenForInput());
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
		mana -= card.getManaCost();
		card.playCard();
		hand.remove(card);
		if(card.getClass().equals(Minion.class))field.add(card);
		for(int i = 0; i < field.size(); i++)
			((Minion)field.get(i)).face.setLocation(350 + 150 * i, 500);
	}
	@Override
	public boolean drawMe(Camera camera) throws Util.NullColorException{
		for(Card c: field)
			((Minion)c).face.drawMe(camera);
		return super.drawMe(camera);
	}
}


