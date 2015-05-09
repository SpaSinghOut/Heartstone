package com.heartstone.main;

import com.spartanlaboratories.engine.structure.Camera;
import com.spartanlaboratories.engine.structure.Human;
import com.spartanlaboratories.engine.structure.Console;
import com.spartanlaboratories.engine.structure.Engine;
import com.spartanlaboratories.engine.structure.Map;
import com.spartanlaboratories.engine.structure.Util.NullColorException;

public class Main extends Map{
	
	Console console; // The console through which the game action are curently being controlled.
	
	public void showMessage(String message){
		console.out(message);
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
		consoleSetup();
		Hero.nextHero = true;
	}
	
	@Override
	public void drawMap(Camera camera){
		super.drawMap(camera);
		for(Hero h:Hero.heroes)
			try {
				h.drawMe(camera);
			} catch (NullColorException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	protected void update() {
		if(Hero.nextHero){
			int heroIndex = Hero.heroes.indexOf(Hero.currentHero) + 1;
			if(heroIndex >= Hero.heroes.size())heroIndex = 0;
			Hero.heroes.get(heroIndex).turn();
		}
	}
	
	private void consoleSetup(){
		console = ((Human)engine.controllers.get(0)).gui.console;			// Consider the existing console
		
		// Set the console to use the executer that is defined in this program
		console.executer = new com.heartstone.main.Executer(this, console);	
		
		// List of program relevant commands that are to be added to the console
		console.addCommand("endturn", 0);
		console.addCommand("fight", 2);
	}
	

	// The Main class constructor. As its purpose is only to set itself up as a map that the engine uses it is placed here alongside the main method.
	private Main(Engine engine){
		super(engine);
	}
	// The main method. Contains only the engine setup and no code relevant to this program itself.
	public static void main(String[] args){
		Engine engine = new Engine();
		Main map = new Main(engine);
		engine.typeHandler.newEntry("map", map);
		engine.init();
		engine.start();
	}
}
