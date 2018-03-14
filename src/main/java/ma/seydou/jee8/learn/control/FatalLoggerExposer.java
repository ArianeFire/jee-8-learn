package ma.seydou.jee8.learn.control;

import java.util.function.Consumer;

import javax.enterprise.inject.Produces;

public class FatalLoggerExposer {

	@Produces
	public Consumer<Throwable> exposeLogger(){
		return Throwable::printStackTrace;
	}
}
