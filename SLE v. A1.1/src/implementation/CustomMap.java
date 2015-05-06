package implementation;

import game.Ability;
import game.Actor;
import game.Alive;
import game.Creep;
import game.Hero;
import structure.Constants;
import structure.Engine;
import structure.Human;
import structure.Location;
import structure.Map;
import ui.AbilityButton;

public class CustomMap extends Map{
	public static void main(String[] args){
		Engine engine = new Engine();
		engine.typeHandler.newEntry("map", new CustomMap(engine));
		engine.init();
		engine.start();
	}
	public CustomMap(Engine engine){
		super(engine);
	}
	@Override
	protected void initializeSpawnPoints() {
		addCreepSpawnPoint(Alive.Faction.RADIANT, new Location(500,1200));
		addCreepSpawnPoint(Alive.Faction.RADIANT, new Location(600, 1200));
	}
	protected void initializeMovePoints(){
		addCreepMovePoint(Alive.Faction.RADIANT, 0, new Location(1000, 1200));
	}

	@Override
	public void init() {
		Human human 				= ((Human)engine.controllers.get(0));
		Hero<CustomAbility> hero 	= new Hero<CustomAbility>(engine, Hero.HeroType.RAZOR, human);
		CustomAbility ability 		= new CustomAbility("fireball", hero);
		
		human.addUnit(hero);
		hero.addAbility(ability);
		hero.changeStat(Constants.damage, 53);
		
		new AbilityButton(ability,human.gui);
		
		initializeMovePoints();
		Creep.setGlobalRule(Creep.MovementRule.CMP);
		initializeSpawnPoints();
		//spawn();
		
		Actor test = new Actor(engine);
		test.setWidth(10);
		test.setHeight(10);
		test.setLocation(new Location(((Alive)engine.controllers.get(0).controlledUnits()[0]).getLocation()));
		test.setLocation(test.getLocation().x + 200, test.getLocation().y);
	}
	protected void generateBorders(){
	}
	protected void drawBorder(){
	}
}
class CustomAbility extends Ability{

	public CustomAbility(String abilityName, Hero<CustomAbility> setOwner) {
		super(abilityName, setOwner);
	}

	@Override
	public void cast() {
		
		
	}
	
}
