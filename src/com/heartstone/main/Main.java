package com.heartstone.main;

import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Human;
import com.spartanlaboratories.engine.structure.Console;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Map;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public class Main extends Map{
	public static void main(String[] args){
		Engine engine = new Engine();
		Main map = new Main(engine);
		engine.typeHandler.newEntry("map", map);
		engine.init();
		Console console = ((Human)engine.controllers.get(0)).gui.console;
		console.executer = new com.heartstone.main.Executer(map, console);
		engine.start();
	}
	private Main(Engine engine){
		super(engine);
	}
	
	public void init(){
		Hero aletheia = new Hero("aletheia", engine);
		Hero vladimir = new Hero("vladimir", engine);
		aletheia.setLocation(500, 111);
		aletheia.fieldVerticalOffset = 200;
		vladimir.setLocation(500,800);
		vladimir.fieldVerticalOffset = -200;
		aletheia.setTexture("JPG", "resources/mage.jpg");
		vladimir.setTexture("JPG", "resources/warlock.jpg");
	}
	@Override //This is the "Override" annotation. It designates an overriding method.
	public void drawMap(Camera camera){
		super.drawMap(camera);
		for(Hero h:Hero.heroes)
			try {
				System.out.println("test");
				h.drawMe(camera);
			} catch (NullColorException e) {
				e.printStackTrace();
			}
	}
	@Override
	protected void update() {
		
		
	} 
}
