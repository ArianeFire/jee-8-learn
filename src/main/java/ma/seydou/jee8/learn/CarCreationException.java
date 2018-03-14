package ma.seydou.jee8.learn;

import javax.ejb.ApplicationException;

/**
 * 
 * @author seberthe
 *
 *
 */
//(Used to avoid EJB Wrap up the exception when it's throw in it, Checked exception can also be used here and throws by the EJB method)
// Using that, Exception may be handled by our defined ExceptionMapper.
@ApplicationException 
public class CarCreationException extends RuntimeException{

	public CarCreationException(String message) {
		super(message);
	}
}
