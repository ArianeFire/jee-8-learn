package ma.seydou.jee8.learn.boundaries;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ma.seydou.jee8.learn.entity.Car;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {

	@Inject
	private CarManufacturer carManufacturer;
	
	@Resource
	ManagedExecutorService mes;
	
	@GET
	public List<Car> retrieveCars(){
		return carManufacturer.retrieveCars();
	}
	
	// We can avoid using the ManagedExecutorService here by turning the CarsResource to @Stateless EJB +
	//Annotate the method with @Asynchronous (Since this annotation work only in EJB)
	@POST
	public void createAsyncCar(Specification specification, @Suspended AsyncResponse asyncResponse) {
		mes.execute(() -> asyncResponse.resume(createCar(specification)));
	}
	
	// OR
	
	public CompletionStage<Response> anotherCreateAsync(Specification specification){
		return CompletableFuture.supplyAsync(() -> createCar(specification), mes); 
	}
	
	private Response createCar(Specification specification) {
		// Car creation Logic
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
