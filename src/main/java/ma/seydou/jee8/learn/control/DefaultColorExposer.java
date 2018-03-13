package ma.seydou.jee8.learn.control;

import javax.enterprise.inject.Produces;

import ma.seydou.jee8.learn.entity.Color;

public class DefaultColorExposer {

	@Produces
	//@Named("diesel") ==> Not the best way (cause "diesel" String) see below for type safe Qualifier (@Diesel)
	@Diesel
	public Color exposeColor() {
		// We can implement any logic here to have a default color
		return Color.BLACK;
	}
}
