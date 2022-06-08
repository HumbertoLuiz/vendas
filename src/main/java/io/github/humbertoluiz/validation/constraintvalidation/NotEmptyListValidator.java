package io.github.humbertoluiz.validation.constraintvalidation;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.github.humbertoluiz.validation.NotEmptyList;

public class NotEmptyListValidator
		implements ConstraintValidator< NotEmptyList, Set<?> > {

	@Override
	public boolean isValid( Set<?> value, ConstraintValidatorContext context ) {
		return value != null && !value.isEmpty();
	}
	
	@Override
	public void initialize(NotEmptyList constraintAnnotation) {
		constraintAnnotation.message();
	}

}
