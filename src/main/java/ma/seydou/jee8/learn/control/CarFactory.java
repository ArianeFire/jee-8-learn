package ma.seydou.jee8.learn.control;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;

import ma.seydou.jee8.learn.annotations.Config;
import ma.seydou.jee8.learn.annotations.Diesel;
import ma.seydou.jee8.learn.boundaries.Specification;
import ma.seydou.jee8.learn.entity.Car;
import ma.seydou.jee8.learn.entity.Color;

// @Dependent //Default Annotation of java bean
//@SessionScoped // Active during user HTTP Session
//@Singleton // One instance of the bean during the application running

public class CarFactory {
	
	@Inject
	//@Named("diesel")
	@Diesel
	Color defaultCarColor;
	@Inject
	@Config("config.prefix")
	private String identifier;
	
	public Car createCar(Specification specification) {
		Car car = new Car();
		car.setIdentifier( identifier + UUID.randomUUID().toString());
		car.setColor(Objects.isNull(specification.getColor()) ? defaultCarColor : specification.getColor());
		car.setEngineType(specification.getEngineType());
		return car;
	}
}
