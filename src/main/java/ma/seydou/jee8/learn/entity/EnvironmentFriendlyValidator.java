package ma.seydou.jee8.learn.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnvironmentFriendlyValidator implements ConstraintValidator<EnvironmentalFriendly, EngineType>{

	@Override
	public void initialize(EnvironmentalFriendly constraintAnnotation) {
		//ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(EngineType arg0, ConstraintValidatorContext arg1) {
		return arg0.equals(EngineType.ELECTRICAL);
	}

}
