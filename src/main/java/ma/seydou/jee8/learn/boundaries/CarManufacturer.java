package ma.seydou.jee8.learn.boundaries;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.seydou.jee8.learn.control.CarFactory;
import ma.seydou.jee8.learn.entity.Car;

@Stateless
public class CarManufacturer {

	@Inject
	CarFactory carFactory;
	
	@PersistenceContext
	EntityManager entityManager;

	public Car manufactor(Specification specification) {
		Car car = carFactory.createCar(specification);
		entityManager.persist(car);
		return car;
	}
	
	
	public List<Car> retrieveCars(){
		return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
	}
	
	public Car retrieveCar(String identifier) {
		return retrieveCars().get(0);
	}

}
