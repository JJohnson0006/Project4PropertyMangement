/*
 * Class: CMSC203 CRN 20798
 * Instructor: Dr. Ahmed Tarek
 * Description: The Property class represents one rental property. It stores
 * the property name, the city, the monthly rent amount, and the
 * owner's name. It has a default constructor, a parameterized
 * constructor, a copy constructor, getters and setters, and a
 * toString method.
 * Due: 10/28/2026
 * Platform/compiler: Eclipse IDE, JDK 26, Mac OS
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Javier Johnson
 */

public class Property {

	// fields (all private so other classes have to use getters and setters)
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;

	/**
	 * Default constructor.
	 * Sets the Strings to empty and the rent amount to 0.
	 */
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
	}

	/**
	 * Parameterized constructor.
	 * Creates a Property using the values that are passed in.
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	/**
	 * Copy constructor.
	 * Creates a new Property that has the same values as another Property.
	 */
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
	}


	/**
	 * Gets the property name.
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Gets the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the monthly rent amount.
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Gets the owner's name.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the property name.
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Sets the city.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Sets the monthly rent amount.
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Sets the owner's name.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns a String with all of the property's information.
	 */
	public String toString() {
		return "Property Name: " + propertyName + ", City: " + city + ", Owner: " + owner + ", Rent: $" + String.format("%.2f", rentAmount);
	}
}
