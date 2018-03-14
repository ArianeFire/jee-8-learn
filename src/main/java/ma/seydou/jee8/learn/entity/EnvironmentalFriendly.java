package ma.seydou.jee8.learn.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = EnvironmentFriendlyValidator.class)
@Documented
public @interface EnvironmentalFriendly {

	String mesage() default "";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
