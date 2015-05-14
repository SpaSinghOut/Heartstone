package com.heartstone.main;

import java.util.ArrayList;

import com.spartanlaboratories.engine.structure.*;
import com.spartanlaboratories.engine.game.*;

public class Hero extends VisibleObject{
	int health, mana, maxMana;
	String name;
	public final static int maxMaxMana = 10;
	public static ArrayList<Hero> heroes = new ArrayList<Hero>();
	volatile ArrayList<Card> deck = new ArrayList<Card>(), hand = new ArrayList<Card>(), field = new ArrayList<Card>(), graveyard = new ArrayList<Card>();
	int fieldVerticalOffset;
	static Hero currentHero;
	static boolean nextHero;
	public Hero(String name, com.spartanlaboratories.engine.structure.Engine engine){
		super(engine); 				// Calls the super constructor passing in the engine instance that this class will be referencing
		this.name = name;			// Sets the name of this hero to the one passed in
		health = 30;				// Sets the health to the default starting health (30)
		heroes.add(this);			// Adds this to the static list of heroes
		createDeck();				// Adds random cards to the deck
		
		/* The values that are being passed in to the following functions are in pixels and therefore will appear different in size on screens with
		* different resolution values. These values were decided on while working on a monitor with the resolution of 1920/1080. These are eventually
		* to be changed to values that represent a proportion of the size of the screen that views them.
		*/
		setWidth(96);				// Sets the width of this hero's portrait to 96 pixels
		setHeight(160);				// Sets the height of this hero's portrait to 160 pixels
		
		// Set the color of this hero's portrait to white.
		color = Util.Color.RED;
		/* Although the portrait is ought to have a texture that covers it, the texture can go along with a color as well.
		 * If a color is not given to the object and the code attempts to draw that object then a NullColorException will be thrown,
		 * it will not terminate the program and will set the color of the object to WHITE. If the color variable is set to a color that is not white
		 * then the texture of this object will be drawn with a shade of that color.
		 */
	}
	public synchronized void turn() {
		
		currentHero = this;		// Sets the static variable that represent the current hero to the current instance
		nextHero = false;		// Prevents code from starting the next player's turn
		resetMana();			// Increases the hero's maximum mana by 1 and changes their current mana to max
		drawCard();				// Draw 1 card
		
		// *** DEBUG CODE *** //
		for(Card c:field){		// For every card on the field
			// Assume that it is a minion type card and find its graphical representation, which is a VisibleObject named face
			VisibleObject face = ((Minion)c).face;
			// Show the card's location on the map
			((Main) engine.map).showMessage("(" + face.getLocation().x + ", " + face.getLocation().y + ")");
		}
		// *** DEBUG CODE *** //
	}
	synchronized void playCard(Card card){
		mana -= card.getManaCost();									// Subtracts the mana cost from the user's mana
		card.playCard();											// Tells the card that it has been played allowing it to prock special effects
		hand.remove(card);											// Removes the card from the hand
		if(card.getClass().equals(Minion.class)){					// If this is a minion type card
			((Minion)card).owner = this;							// First set self as the card's owner
			field.add(card);										// Then add it to the field and initialize its graphics
			((Minion)card).setFace(engine, "JPG", "resources/" + ((Minion)card).preset.toString().toLowerCase() + ".jpg");
		}
		for(int i = 0; i < field.size(); i++)						// Reconfigure Minion positions
			((Minion)field.get(i)).face.setLocation(350 + 150 * i, getLocation().y + fieldVerticalOffset);
	}
	public synchronized boolean drawMe(Camera camera) throws /*a large dog out the window*/ Util.NullColorException{
		for(Card c: field)
			((Minion)c).drawMe(camera);
		int increment = 0;
		for(Card c: hand){
			((Minion)c).face.setLocation(350 + 150 * increment++, getLocation().y - fieldVerticalOffset);
			((Minion)c).drawMe(camera);
		}
		return super.drawMe(camera);
	}
	private void createDeck() { 
		for(int i = 0; i < 30; i++)
			deck.add(new Minion(Minion.Preset.values()[(int)(Math.random()*Minion.Preset.values().length)]));
	}
	private Card drawCard(){
		Card card = deck.get((int)(Math.random()*deck.size()));						// Gets a random card from the deck
		hand.add(card);																// Puts the card into the player's hand
		deck.remove(card);															// Removes the card from the deck
		if(card.getClass().equals(Minion.class))((Minion)card).setFace(engine, "jpg", "resources/" + ((Minion)card).name() + ".jpg");
		System.out.println("The player " + name +" drew the card " + card.name());	// Debug code
		return /*The BEST*/card;																// Returns the card that was drawn
	}
	private void resetMana(){
		// Set the mana equal to max mana, the value of which is incremented by one.
		mana=++maxMana;
		System.out.println("The player " + name + " has " + mana + " mana"); // Debug code
	}
}


