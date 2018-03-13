package ma.seydou.jee8.learn.boundaries;

import ma.seydou.jee8.learn.entity.Color;
import ma.seydou.jee8.learn.entity.EngineType;

public class Specification {

	private final Color color;
	private final EngineType engineType;
	
	public Specification(Color color, EngineType engineType) {
		super();
		this.color = color;
		this.engineType = engineType;
	}
	public Color getColor() {
		return color;
	}
	public EngineType getEngineType() {
		return engineType;
	}	
	
}
