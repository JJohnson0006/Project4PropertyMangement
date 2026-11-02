/*
 * Class: CMSC203 CRN 20798
 * Instructor: Dr. Ahmed Tarek
 * Description: PropertyDriver is the console driver. It
 * creates a ManagementCompany, adds Property objects to it, and
 * prints the results. It also shows how the copy constructors
 * work and what happens when the company is full.
 * Due: 10/28/2026
 * Platform/compiler: Eclipse IDE,JDK 26, Mac OS
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Javier Johnson
 */

public class PropertyDriver {

	/**
	 * The main method. Runs each part of the demo in order.
	 */
	public static void main(String[] args) {

		System.out.println("===== Property Management Application =====\n");

		// 1. Create the management company (holds an array of Property objects)
		ManagementCompany company = new ManagementCompany("Campus Realty", "123-45-6789");

		// 2. Create some properties and add them to the company
		Property p1 = new Property("Maple Apartments", "Rockville", 1200.00, "Bob Smith");
		Property p2 = new Property("Oak Townhouse", "Germantown", 1500.00, "Carol Jones");
		Property p3 = new Property("Pine Studio", "Silver Spring", 950.50, "Dan Lee");

		int index1 = company.addProperty(p1);
		int index2 = company.addProperty(p2);
		int index3 = company.addProperty(p3);

		System.out.println("Added " + p1.getPropertyName() + " at index " + index1);
		System.out.println("Added " + p2.getPropertyName() + " at index " + index2);
		System.out.println("Added " + p3.getPropertyName() + " at index " + index3);
		System.out.println();

		// 3. Print the company information (uses toString)
		System.out.println(company.toString());
		System.out.println();

		// 4. Show the Property copy constructor
		System.out.println("----- Property Copy Constructor -----");
		Property copyOfP1 = new Property(p1);
		copyOfP1.setRentAmount(1300.00);   // only change the copy
		System.out.println("Original: " + p1.toString());
		System.out.println("Copy:     " + copyOfP1.toString());
		
		System.out.println("Changing the copy's rent did not change the original.");
		System.out.println();

		// 5. Show the ManagementCompany copy constructor (deep copy)
		System.out.println("----- ManagementCompany Copy Constructor -----");
		ManagementCompany companyCopy = new ManagementCompany(company);
		
		companyCopy.addProperty(new Property("Cedar House", "Bethesda", 2000.00, "Eve Brown"));
		System.out.println("Original company count: " + company.getPropertyCount() + ", total rent: $" + String.format("%.2f", company.totalRent()));
		
		
		System.out.println("Copied company count:   " + companyCopy.getPropertyCount()+ ", total rent: $" + String.format("%.2f", companyCopy.totalRent()));
		
		
		System.out.println("Adding to the copy did not change the original company.");
		System.out.println();

		// 6. Fill the array and try to add one more property
		System.out.println("----- Filling the Company -----");
		company.addProperty(new Property("Birch Duplex", "Rockville", 1100.00, "Frank White"));
		
		
		company.addProperty(new Property("Elm Condo", "Gaithersburg", 1350.00, "Grace Kim"));
		System.out.println("Property count is now " + company.getPropertyCount() + " (max is " + ManagementCompany.MAX_PROPERTIES + ")");

		int result = company.addProperty(new Property("Extra Place", "Olney", 900.00, "Hank Green"));
		if (result == -1) {
			System.out.println("Could not add Extra Place: the company is full (returned -1).");
		}
		System.out.println();

		// 7. Print the final company information
		System.out.println(company.toString());
		System.out.println();

		System.out.println("Programmer: Javier Johnson");
	}
}
