package ma.seydou.jee8.learn.control;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.LockSupport;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

import ma.seydou.jee8.learn.entity.Car;

@Stateless

public class CarProcessor {
	
	@Resource
	ManagedExecutorService mes;
	
	// We may also achieve this by Returning a Future (AsyncResult implementation) as the result.
	@Asynchronous // Wherever you call this method, it will run asynchronously 
	public void processNewCarAsynchronous(Car car) {
		LockSupport.parkNanos(2_000_000_000L);
		String result = String.format("Processed Car : %s", car);
		System.out.println(result);
	}
	
	public void processNewCar(Car car) {
		LockSupport.parkNanos(2_000_000_000L);
		String result = String.format("Processed Car : %s", car);
		
		//Use CompletableFuture here when you want to launch another parallel thing here (Atmost in case of the Stream.parallel() stuff)
		//CompletableFuture.supplyAsync(() -> null, mes);
		
		System.out.println(result);
	}
}
