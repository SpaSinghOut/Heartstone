package game;

import structure.Camera;
import structure.Engine;
import structure.Util;

public class TerrainObject extends VisibleObject{
	public static final int defaultTerrainSize = 30;
	static final Util.Color defaultColor = Util.Color.PURPLE;
	public TerrainObject(Engine engine){
		super(engine);
		immobile = true;
		solid = true;
		setWidth(defaultTerrainSize);
		setHeight(defaultTerrainSize);
		color = defaultColor;
	}
	public boolean drawMe(Camera camera){
		return super.drawMe(camera,engine.util.getRGB(color));
	}
}
