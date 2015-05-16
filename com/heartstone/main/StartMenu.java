package com.heartstone.main;

import javax.swing.JFrame;

import com.spartanlaboratories.startmenu.DefaultStartScreen;
import com.spartanlaboratories.startmenu.Screen;
import com.spartanlaboratories.startmenu.ScreenHolder;

public class StartMenu extends JFrame implements ScreenHolder{
	public static boolean startGame;
	public StartMenu(){
		super("HeartStone");
		setVisible(true);
		setLocation(0,0);
		setSize(500,500);
		Screen main = new DefaultStartScreen(this);
		main.load();
		long time = System.nanoTime();
		while(true)if(System.nanoTime() > time + 1000000000){
			time += 1000000000;
			if(startGame)break;
		}
		setVisible(false);
	}
	@Override
	synchronized public void startGame() {
		System.out.println("test");
		startGame = true;
	}

	@Override
	public void updateScreen(Screen screen) {
		for(Screen s:screens)s.unload();
		screen.load();
	}

}
