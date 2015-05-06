package com.heartstone.main;

import structure.*;
import structure.Util.NullColorException;

public class Main extends Map{
	public static void main(String[] args){
		Engine engine = new Engine();
		engine.typeHandler.newEntry("map", new Main(engine));
		engine.init();
		engine.start();
	}
	Main(Engine engine){
		super(engine);
	}
	
	public void init(){
		Hero aletheia = new Hero("aletheia", engine);
		Hero vladimir = new Hero("vladimir", engine);
		aletheia.setLocation(500, 111);
		vladimir.setLocation(500,800);
		aletheia.setTexture("JPG", "resources/mage.jpg");
		vladimir.setTexture("JPG", "resources/warlock.jpg");
	}
	
	public void update(){
		for(Hero h:Hero.heroes)
			h.turn();
	}
	@Override
	public void drawMap(Camera camera){
		super.drawMap(camera);
		for(Hero h:Hero.heroes)
			try {
				h.drawMe(camera);
			} catch (NullColorException e) {
				System.out.println("A null color exception has occured because an object of type " + h.getClass().getName() + " does not have their color initialized");
				e.printStackTrace();
				h.color = Util.Color.WHITE;
			}
	}
	
	protected void drawBorder(){} 				// Ignore this
	protected void initializeSpawnPoints(){} 	// This also
												// Those just have to be there
												// Deal with it
}
