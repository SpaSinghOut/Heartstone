package game;

import structure.Camera;
import structure.Location;

public interface AcceptsInput {
	public void rightClick(Location locationOnScreen, Camera camera);
	public void leftClick(Location locationOnScreen, Camera camera);
	public void keyPress(String key);
}
