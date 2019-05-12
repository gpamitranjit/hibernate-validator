package org.hibernate.validator.referenceguide.chapter02.classlevel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidPassengerCount.Validator.class })
@Documented
/**
 * the car is valid only if the seatCount is minimum of 2 and passengers are min of 2
 */
public @interface ValidPassengerCount {

	String message() default "{org.hibernate.validator.referenceguide.chapter02.classlevel.ValidPassengerCount.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	class Validator
			implements ConstraintValidator<ValidPassengerCount, Car> {

		@Override
		public void initialize(ValidPassengerCount constraintAnnotation) {
		}

		@Override
		public boolean isValid(Car car, ConstraintValidatorContext context) {
			if(car.getSeatCount() < 2 || car.getPassengers().size() < 2)
				return false;
			return true;
		}
	}
}
