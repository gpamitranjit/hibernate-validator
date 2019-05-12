//tag::include[]
package org.hibernate.validator.referenceguide.chapter02.classlevel;

//end::include[]

import java.util.List;

//tag::include[]
@ValidPassengerCount
public class Car {

	private int seatCount;

	private List<Person> passengers;

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public List<Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Person> passengers) {
		this.passengers = passengers;
	}

	
	//...
}
//end::include[]
