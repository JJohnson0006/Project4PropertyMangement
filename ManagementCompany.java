/*
 * Class: CMSC203 CRN 20798
 * Instructor: Dr. Ahmed Tarek
 * Description: The ManagementCompany class represents a company that manages
 * rental properties. It HAS-A array of Property objects
 * (aggregation). It can add properties to the array, count them,
 * add up the total rent, and make a deep copy of itself.
 * Due: 10/28/2026
 * Platform/compiler: Eclipse IDE, JDK 26 , MAC OS
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Javier Johnson
 */

public class ManagementCompany {

	// the most properties one company can manage (size of the array)
	public static final int MAX_PROPERTIES = 5;

	
	private String name;
	private String taxId;
	private Property[] properties;
	private int propertyCount;

	/**
	 * Parameterized constructor.
	 * Sets the name and tax ID, creates an empty array that can hold
	 * MAX_PROPERTIES properties, and starts the count at 0.
	 */
	public ManagementCompany(String name, String taxId) {
		this.name = name;
		this.taxId = taxId;
		properties = new Property[MAX_PROPERTIES];
		propertyCount = 0;
	}

	/**
	 * Copy constructor (deep copy).
	 * Copies the name, tax ID and count from another company. It also makes
	 * a brand new array and a brand new copy of every Property, so the two
	 * companies do not share any Property objects.
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxId = otherCompany.taxId;
		this.propertyCount = otherCompany.propertyCount;
		this.properties = new Property[MAX_PROPERTIES];

		// copy each property one at a time using the Property copy constructor
		for (int i = 0; i < otherCompany.propertyCount; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
	}

	/**
	 * Adds a property to the company.
	 * A copy of the property is stored in the array (not the original),
	 * so changes made to the original later will not change the company.
	 */
	public int addProperty(Property p) {
		if (p == null) {
			return -2;
		}

		if (propertyCount == MAX_PROPERTIES) {
			return -1;
		}

		properties[propertyCount] = new Property(p);
		int index = propertyCount;
		propertyCount++;
		return index;
	}

	/**
	 * Adds up the rent of every property in the company.
	 */
	public double totalRent() {
		double total = 0.0;

		for (int i = 0; i < propertyCount; i++) {
			total = total + properties[i].getRentAmount();
		}

		return total;
	}

	/**
	 * Gets how many properties are in the company right now.
	 */
	public int getPropertyCount() {
		return propertyCount;
	}

	/**
	 * Gets the company name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the company tax ID.
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * Gets a copy of the property
	 */
	public Property getProperty(int index) {
		if (index < 0 || index >= propertyCount) {
			return null;
		}
		return new Property(properties[index]);
	}

	/**
	 * Checks if the company has no more room for properties.
	 */
	public boolean isFull() {
		return propertyCount == MAX_PROPERTIES;
	}

	/**
	 * Returns a summary of the company: its name, tax ID, every property,
	 * and the total rent.
	 */
	public String toString() {
		String result = "Management Company: " + name + "\n";
		result = result + "Tax ID: " + taxId + "\n";
		result = result + "Number of Properties: " + propertyCount + "\n";
		result = result + "------------------------------------------\n";

		if (propertyCount == 0) {
			result = result + "No properties have been added yet.\n";
		}

		for (int i = 0; i < propertyCount; i++) {
			result = result + (i + 1) + ". " + properties[i].toString() + "\n";
		}

		result = result + "------------------------------------------\n";
		result = result + "Total Rent: $" + String.format("%.2f", totalRent());
		return result;
	}
}
