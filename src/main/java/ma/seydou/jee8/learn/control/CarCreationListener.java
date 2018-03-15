package ma.seydou.jee8.learn.control;

import java.util.concurrent.locks.LockSupport;

import javax.ejb.Stateless;
import javax.enterprise.event.ObservesAsync;

import ma.seydou.jee8.learn.entity.CarCreated;

@Stateless
//@Asynchronous // This can be avoided by firing the event asynchronously
public class CarCreationListener {

	// Notice that the event Listener have a void signature
	// Notice we're observing an Asynchronous event
	public void onCarCreated(@ObservesAsync CarCreated carCreated) {
		LockSupport.parkNanos(2_000_000_000L);
		System.out.println("New Created Car with ID " + carCreated.getIdentifier());
	}
}
