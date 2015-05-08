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
		engine.start();
	}
	public void showMessage(String message){
		console.out(message);
	}
	Console console;
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
	
	private Main(Engine engine){
		super(engine);
	}
	
	private void consoleSetup(){
		console = ((Human)engine.controllers.get(0)).gui.console;
		console.executer = new com.heartstone.main.Executer(this, console);
		console.addCommand("endturn", 0);
	}
}
