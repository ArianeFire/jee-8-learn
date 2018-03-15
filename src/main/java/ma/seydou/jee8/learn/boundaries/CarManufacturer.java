package ma.seydou.jee8.learn.boundaries;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import ma.seydou.jee8.learn.control.CarFactory;
import ma.seydou.jee8.learn.control.CarProcessor;
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
	@Inject
	CarProcessor carProcessor;
	
	@Resource
	ManagedExecutorService executorService;

	public Car manufactor(Specification specification) {
		Car car = carFactory.createCar(specification);
		carRepository.store(car);
		//The Event Fire is this case Asynchronously, the next line will not wait until the Listener finish
		// This way of handling event give us Loosely coupled mechanism
		carCreatedEvent.fireAsync(new CarCreated(car.getIdentifier()));
		carProcessor.processNewCarAsynchronous(car);
		
		//This is called synchronously cause it doesn't have a @Asynchronous (or Based on it current definition) => See below on how to excecute it Async. without the annotation. 
		//carProcessor.processNewCar(car);
		
		 // this allow us to avoid creating our own thread, instead we delegate the calling to entreprise thread executor (Never create your a new thread in entreprise app)
		executorService.execute(() -> carProcessor.processNewCar(car));
		//
		return car;
	}
	
	public List<Car> retrieveCars(){
		return carRepository.loadCars();
	}

}
