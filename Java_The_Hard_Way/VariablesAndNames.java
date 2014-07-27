public class VariablesAndNames
{
	public static void main( String[] args )
	{
		int cars, drivers, passengers, cars_not_driven, cars_driven;
		double space_in_a_car, carpool_capacity, average_passengers_per_car;
		// defines that cars == 100
		cars = 100;
		// defines that each car has 4 spaces
		space_in_a_car = 4;
		//defines how many drivers, 30 drivers.
		drivers = 30;
		//defines how many passengers, 90 passengers
		passengers = 90;
		//variable to represent cars that are not driven. Takes 100 - 30.
		cars_not_driven = cars - drivers;
		//car driven = the same amount as driver variable. 30
		cars_driven = drivers;
		//defines variable that is 30 * 4
		carpool_capacity = cars_driven * space_in_a_car;
		//define variable that is 90 / 30
		average_passengers_per_car = passengers / cars_driven;
		
		System.out.println( "There are " + cars + " cars available." );
		System.out.println( "There are only " + drivers + " drivers available." );
		System.out.println( "There will be " + cars_not_driven + " empty cars today." );
		System.out.println( "We can transport " + carpool_capacity + " people today. " );
		System.out.println( "We have " + passengers + " to carpool today." );
		System.out.println( "We need to put about " + average_passengers_per_car + " in each car." );
	}
}