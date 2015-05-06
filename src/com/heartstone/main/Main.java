package com.heartstone.main;

import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Map;
import com.spartanlaboratories.engine.structure.Util;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

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
				e.printStackTrace();
				h.color = Util.Color.WHITE;
			}
	}
	
	protected void drawBorder(){} 				// Ignore this
	protected void initializeSpawnPoints(){} 	// This also
												// Those just have to be there
												// Deal with it
}
