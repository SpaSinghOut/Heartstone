/*            $$$$$$ INSTRUCTIONS ON THE USAGE OF THE CONSOLE $$$$$$
 * 
 *	1. Turning on the console:
 * 			After having started the game the user can access the console by pressing the f3 key and clicking on the text bar 
 * 			in the bottom right corner that says "write something here". Most of the time after clicking on the text bar that message will 
 * 			disappear, if not try clicking again or erasing it with the backspace and delete buttons.
 * 
 * 2. Typing in a command
 * 			The console is tuned to recognize a command as a word that follows the ! symbol also known as the command identifier. 
 * 			For example if the user is trying to put in a command that ends their turn, the command should look like this: "!endturn". 
 * 			Also the console will only read one word after the command identifier so "!end turn" or "! endturn" will not work.
 * 
 * 3. Entering command parameters
 * 			Each command that the console recognizes is tuned to read a certain number of parameters after it.
 * 			These parameters will affect how the command is executed and the command's execution is dependent on their presence.
 * 			For example the command "fight" is tuned to have 2 parameters, each of which represent the card on the field that will be fighting
 * 			so it should look like this: "!fight 1 1"
 * 	
 * 4. Overriding 
 * 			The console does NOT support having multiple commands of the same name and a different number of parameters. Although no error will 
 * 			occur when attempting to either store or execute either of the commands, the console will not function properly as it will assume that 
 * 			the user is trying to execute the first command of that name that was put in.

*/
package com.heartstone.main;

import com.spartanlaboratories.engine.structure.Console;

public class Executer extends Console.Executer{
	Main main;
	Executer(Main main, Console console) {
		console.super(console);
		this.main = main;
	}
	@Override
	public boolean execute(String[] readReadyCommand){
		try {
			if(super.execute(readReadyCommand))return true;
		} catch (CommandExecutionException e) {
			owner.out(e.getLocalizedMessage());
		}
		switch(readReadyCommand[0]){
		case "endturn": 
			this.owner.out("The player: " + Hero.currentHero.name + " has ended their turn.");
			Hero.nextHero = true;
			break;
		case "fight":
			// Works with the engine version 1.2.1
			
			int attackerIndex = Integer.parseInt(readReadyCommand[1]) - 1;
			Minion attacker = (Minion) Hero.currentHero.field.get(attackerIndex);
			int victimIndex = Integer.parseInt(readReadyCommand[2]) - 1;
			Minion victim = (Minion) Hero.heroes.get(Hero.heroes.indexOf(Hero.currentHero) - 1).field.get(victimIndex);
			attacker.attack(victim);
			break;
		case "playcard":
			// Will ATTEMPT to play a card from a player's hand to the field.
			// Will not do so if the player does not have the required mana.
			
			if(Hero.currentHero.mana > Hero.currentHero.hand.get(Integer.parseInt(readReadyCommand[1])-1).getManaCost())
				Hero.currentHero.playCard(Hero.currentHero.hand.get(Integer.parseInt(readReadyCommand[1])-1));
			break;
			
		default: return false;
		}
		return true;
	}
}
