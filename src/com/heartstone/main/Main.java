package com.heartstone.main;

public class Main {

	public static void main(String[] args) {
		new Main().go();
	}
	Main(){
		Card fierceGnome = new Card(1,2,1);
		Card nightwolf = new Card(3,3,3);
		Card burningCrusader = new Card(2,1,3);
		Card dreadnought = new Card(5,6,5);
		Card savageLion = new Card(3,5,1);
		Card bandit = new Card(2,2,2);
		Card leapingTiger = new Card(3,4,2);
		Card wisp = new Card(1,1,1);
		Card blackAngel = new Card(8,9,7);
		Card ghoul = new Card(2,2,4);
		Hero aletheia = new Hero(30);
		System.out.println(aletheia);
		
	}
	void go(){
		while(true){
			
		}
	}
}
