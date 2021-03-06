package ma.seydou.jee8.learn.boundaries;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import ma.seydou.jee8.learn.control.CarFactory;
import ma.seydou.jee8.learn.control.CarRepository;
import ma.seydou.jee8.learn.entity.Car;
import ma.seydou.jee8.learn.entity.CarCreated;

@Stateless
public class CarManufacturer {

	@Inject
	CarFactory carFactory;
	@Inject
	CarRepository carRepository;
	@Inject
	Event<CarCreated> carCreatedEvent;

	public Car manufactor(Specification specification) {
		Car car = carFactory.createCar(specification);
		carRepository.store(car);
		//The Event Fire is this case (Default) synchronously, the next line will not be executed until the Listener finish
		// This way of handling event give us Loosely coupled mechanism
		carCreatedEvent.fire(new CarCreated(car.getIdentifier()));
		return car;
	}
	
	public List<Car> retrieveCars(){
		return carRepository.loadCars();
	}

}
