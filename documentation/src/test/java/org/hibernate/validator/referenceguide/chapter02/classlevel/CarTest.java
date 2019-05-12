package org.hibernate.validator.referenceguide.chapter02.classlevel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

	private static Validator validator;
	
	@BeforeClass
	public static void setValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void validCarObjectTest() {
		Car car = new Car();
		car.setSeatCount(2);
		Person person1 = new Person();
		Person person2 = new Person();
		List<Person> passengers = new ArrayList<>();
		passengers.add(person1);
		passengers.add(person2);
		car.setPassengers(passengers);
		
		Set<ConstraintViolation<Car>> constraintVoilations = validator.validate(car);
		assertEquals(0, constraintVoilations.size());
	}
	
	@Test
	public void invalidCarObjectTest() {
		Car car = new Car();
		car.setSeatCount(1);
		Person person1 = new Person();
		Person person2 = new Person();
		List<Person> passengers = new ArrayList<>();
		passengers.add(person1);
		passengers.add(person2);
		car.setPassengers(passengers);
		
		Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
		assertEquals(1, constraintViolations.size());
	}
}
