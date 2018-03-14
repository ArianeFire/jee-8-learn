package ma.seydou.jee8.learn.control;



import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.function.Function;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import ma.seydou.jee8.learn.annotations.Tracked;
import ma.seydou.jee8.learn.control.ProcessTracker.Category;

@Interceptor
@Tracked(Category.UNSED)
@Priority(Interceptor.Priority.APPLICATION)
public class ProcessTrackingInterceptor {

	@Inject
	ProcessTracker processTracker;
	
	@AroundInvoke
	public Object aroundInvokation(InvocationContext context) throws Exception {
		System.out.println("Manufaction Intercepted....");
		Tracked tracked = retrieveAnnotation(context);
		processTracker.track(tracked);
		return context.proceed();
	}
	
	private Tracked retrieveAnnotation(InvocationContext context) {
		Method method = context.getMethod();
		Function<AnnotatedElement, Tracked> extractor = c -> c.getAnnotation(Tracked.class);
		Tracked tracked = extractor.apply(method);
		return tracked != null ? tracked : extractor.apply(method.getDeclaringClass());
	}
}
