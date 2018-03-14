package ma.seydou.jee8.learn.boundaries;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import ma.seydou.jee8.learn.entity.Color;
import ma.seydou.jee8.learn.entity.EngineType;

@Path("cars")
public class CarsResource {

	@Inject
	private CarManufacturer carManufacturer;
	
	@GET
	public JsonArray retrieveCars(){
		return carManufacturer.retrieveCars().stream()
				.map(car -> 
						Json.createObjectBuilder()
						.add("color", car.getColor().name())
						.add("engine", car.getEngineType().name())
						.add("id", car.getIdentifier())
						.add("hello", "world")
						.build())
				.collect(JsonCollectors.toJsonArray());
	}
	
	@POST
	public void createCar(JsonObject specification) {
		
		Color color = Color.valueOf(specification.getString("color"));
		EngineType engine = EngineType.valueOf(specification.getString("engine"));
		carManufacturer.manufactor(new Specification(color, engine));
	}
}
