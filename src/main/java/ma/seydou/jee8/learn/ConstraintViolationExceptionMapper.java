package ma.seydou.jee8.learn;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException arg0) {
		
		return Response.status(Status.BAD_REQUEST).header("X-Validation-Error", arg0.getMessage())
				.entity(arg0.getMessage())
				.build();
	}

}
