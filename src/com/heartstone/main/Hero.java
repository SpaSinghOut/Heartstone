package com.heartstone.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero {
	int health, mana, maxMana;
	String name;
	Scanner inputListener = new Scanner(System.in);
	public final static int maxMaxMana = 10;
	public static ArrayList<Hero> heroes = new ArrayList<Hero>();
	ArrayList<Card> deck = new ArrayList<Card>(), hand = new ArrayList<Card>(), field = new ArrayList<Card>();
	public Hero(String name){
		this.name = name;
		health = 30;
		heroes.add(this);
		createDeck();
	}
	private void createDeck() {
		for(int i = 0; i < 30; i++)deck.add(Card.values()[(int)(Math.random()*Card.values().length)]);
		
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
		Card card = deck.get((int)(Math.random()*deck.size()));
		hand.add(card);
		System.out.println("The player " + name +" drew the card " + card.name());
	}
	private void changeMana(){
		mana=++maxMana;
		System.out.println("The player " + name + " has " + mana + " mana");
	}
}


