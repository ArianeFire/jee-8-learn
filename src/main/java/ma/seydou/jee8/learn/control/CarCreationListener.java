package ma.seydou.jee8.learn.control;

import javax.enterprise.event.Observes;

import ma.seydou.jee8.learn.entity.CarCreated;

public class CarCreationListener {

	// Notice that the event Listener have a void signature
	public void onCarCreated(@Observes CarCreated carCreated) {
		System.out.println("New Created Car with ID " + carCreated.getIdentifier());
	}
}
