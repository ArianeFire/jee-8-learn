package ma.seydou.jee8.learn.control;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import ma.seydou.jee8.learn.entity.Car;
import ma.seydou.jee8.learn.entity.Color;
import ma.seydou.jee8.learn.entity.EngineType;

public class CarRepository {

	public void store(Car car) {
		//TODO
	}

	public List<Car> loadCars() {
		Car car1 = new Car();
		car1.setColor(Color.BLACK);
		car1.setEngineType(EngineType.DIESEL);
		car1.setIdentifier(UUID.randomUUID().toString());
		return Arrays.asList(car1);
	}

}
