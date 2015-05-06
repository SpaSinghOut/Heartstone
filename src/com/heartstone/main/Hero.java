package com.heartstone.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.spartanlaboratories.engine.game.VisibleObject;
import com.spartanlaboratories.engine.structure.Engine;

public class Hero extends VisibleObject{
	int health, mana, maxMana;
	String name;
	Scanner inputListener = new Scanner(System.in);
	public final static int maxMaxMana = 10;
	public static ArrayList<Hero> heroes = new ArrayList<Hero>();
	ArrayList<Minion> deck = new ArrayList<Minion>(), hand = new ArrayList<Minion>(), field = new ArrayList<Minion>();
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
		changeMana();
		drawCard();
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
	private void drawCard(){
		Minion card = deck.get((int)(Math.random()*deck.size()));
		hand.add(card);
		System.out.println("The player " + name +" drew the card " + card.name());
	}
	private void changeMana(){
		mana=++maxMana;
		System.out.println("The player " + name + " has " + mana + " mana");
	}
	    public void subtractMana(int netChange) {
	   	 mana -= netChange;
	    }
	   /*void playCard(Card card){
	   	subtractMana(card.mana); //Do we need?
	   }*/
}


