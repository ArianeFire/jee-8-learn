package ma.seydou.jee8.learn.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.seydou.jee8.learn.entity.Car;

@Singleton
@Startup  //Will Be create this bean on Application StartUp
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CarCache {

	private final Map<String, Car> cache = new ConcurrentHashMap<>();
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostConstruct
	private void initCach() {
		loadCars();
	}
	
	@Schedule(hour = "*") // Same as Linux terminology, In this case, the method will be called every hour (Reload the car cache)
	public void loadCars() {
		//Entity Manager Find All Cars here.
		//entityManager.createNamedQuery(FIND_ALL, Car.class)
		
		// Put retrieved cars in the cache by their identifier.
	}

	public List<Car> retrieveCars(){
		return new ArrayList<>(cache.values());
	}

	public void cache(Car car) {
		cache.put(car.getIdentifier(), car);
	}
}
