package ma.seydou.jee8.learn;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CarCreationExceptionMapper implements ExceptionMapper<CarCreationException> {

	@Override
	public Response toResponse(CarCreationException arg0) {
		
		return Response.serverError().header("X-Car-Error", arg0.getMessage())
				.entity(arg0.getMessage())
				.build();
	}

}
