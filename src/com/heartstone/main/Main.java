package com.heartstone.main;

public class Main {

	public static void main(String[] args) {
		new Main().go();
	}
	Main(){
		Card spartak = new Card(2,5);
		Card nick = new Card(1,4);
		System.out.printf("Spartak has %d damage and %d health\n", spartak.damage, spartak.health);
		System.out.printf("Nick has %d damage and %d health\n", nick.damage, nick.health);
		spartak.attack(nick);
		System.out.println("Spartak attacked nick");
		System.out.printf("Spartak has %d damage and %d health\n", spartak.damage, spartak.health);
		System.out.printf("Nick has %d damage and %d health\n", nick.damage, nick.health);
		Card Dreadnought = new Card(6,5);
		System.out.printf("Dreadnought has %d damage and %d health\n", Dreadnought.damage, Dreadnought.health);
		Dreadnought.attack(spartak);
		System.out.printf("Dreadnought attacked spartak\n");
		System.out.printf("spartak has %d damage and %d health\n", spartak.damage, spartak.health);
	}
	void go(){
		while(true){
			
		}
	}
}
