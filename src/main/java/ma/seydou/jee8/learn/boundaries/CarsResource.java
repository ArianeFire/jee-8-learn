package ma.seydou.jee8.learn.boundaries;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ma.seydou.jee8.learn.entity.Car;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarsResource {

	@Inject
	private CarManufacturer carManufacturer;
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	public List<Car> retrieveCars(@NotNull @QueryParam("query") String query){
		return carManufacturer.retrieveCars();
	}
	
	@POST
	public Response createCar(@Valid @NotNull Specification specification) {
		Car car = carManufacturer.manufactor(specification);
		URI url = uriInfo.getBaseUriBuilder()
				.path(CarsResource.class)
				.path(CarsResource.class, "retrieveCar")
				.build(car.getIdentifier());
		return Response.created(url).build();
	}
	
	@GET
	@Path("/{id}")
	public Car retrieveCar(@PathParam("id") String identifier) {
		return carManufacturer.retrieveCar(identifier);
	}
}
