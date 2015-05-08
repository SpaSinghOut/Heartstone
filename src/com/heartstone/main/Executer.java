package com.heartstone.main;

import com.spartanlaboratories.engine.structure.Console;
import com.spartanlaboratories.engine.ui.GraphicalConsole;
import com.spartanlaboratories.engine.ui.Gui;

public class Executer extends Console.Executer{
	Main main;
	Executer(Main main, Console console) {
		console.super(console);
		this.main = main;
	}
	@Override
	public void execute(String[] readReadyCommand){
		switch(readReadyCommand[0]){
		case "endturn": 
			this.owner.out("The player: " + Hero.currentHero.name + " has ended their turn.");
			Hero.nextHero = true;
			break;
		}
	}
}
