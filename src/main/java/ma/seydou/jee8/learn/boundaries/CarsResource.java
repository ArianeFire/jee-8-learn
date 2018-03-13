package ma.seydou.jee8.learn.boundaries;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.seydou.jee8.learn.entity.Car;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {

	@Inject
	private CarManufacturer carManufacturer;
	
	@GET
	public List<Car> retrieveCars(){
		return carManufacturer.retrieveCars();
	}
}
