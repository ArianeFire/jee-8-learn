package ma.seydou.jee8.learn.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

import ma.seydou.jee8.learn.control.ProcessTracker;
import ma.seydou.jee8.learn.control.ProcessTracker.Category;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Tracked {

	@Nonbinding
	ProcessTracker.Category value();
}
