package ma.seydou.jee8.learn.boundaries;

import javax.validation.constraints.NotNull;

import ma.seydou.jee8.learn.entity.Color;
import ma.seydou.jee8.learn.entity.EngineType;
import ma.seydou.jee8.learn.entity.EnvironmentalFriendly;

public class Specification {

	@NotNull
	private  Color color;
	@NotNull
	@EnvironmentalFriendly
	private  EngineType engineType;
	
	public Specification(Color color, EngineType engineType) {
		super();
		this.color = color;
		this.engineType = engineType;
	}
	
	public Specification() {
		super();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
	
}
