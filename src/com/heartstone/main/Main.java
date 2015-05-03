package com.heartstone.main;

public class Main {

	public static void main(String[] args) {
		new Main().go();
	}
	Main(){
		new Hero("aletheia");
		new Hero("vladimir");
	}
	void go(){
		while(true){
			for(Hero h:Hero.heroes)
				h.turn();
		}
	}
}
