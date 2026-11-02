/*
 * Class: CMSC203 CRN 20798
 * Instructor: Dr.Ahmed Tarek
 * Description: PropertyAppFX is the JavaFX GUI for Assignment 4. The user
 * types in a property's name, city, rent and owner and clicks
 * "Add Property". The "Show All Properties" and "Show Total Rent"
 * buttons display the company's information in a TextArea.
 * It uses a ManagementCompany object just like the driver does.
 * Due: 10/28/2026
 * Platform/compiler: Eclipse IDE, JDK 26, Mac OS
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Javier Johnson
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {

	// the company that holds all the properties entered in the GUI
	private ManagementCompany company = new ManagementCompany("Campus Realty", "123-45-6789");

	// text fields for the user's input
	private TextField nameField;
	private TextField cityField;
	private TextField rentField;
	private TextField ownerField;

	// label for messages (errors or success) and area for the output
	private Label messageLabel;
	private TextArea outputArea;

	/**
	 * Builds the window: the input form, the buttons, the message label
	 * and the output area.
	 */
	public void start(Stage primaryStage) {

		Label titleLabel = new Label("Property Management - " + company.getName());
		titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

		// input form (labels on the left, text fields on the right)
		nameField = new TextField();
		cityField = new TextField();
		rentField = new TextField();
		ownerField = new TextField();

		GridPane form = new GridPane();
		form.setHgap(10);
		form.setVgap(8);
		form.add(new Label("Property Name:"), 0, 0);
		form.add(nameField, 1, 0);
		form.add(new Label("City:"), 0, 1);
		form.add(cityField, 1, 1);
		form.add(new Label("Rent Amount:"), 0, 2);
		form.add(rentField, 1, 2);
		form.add(new Label("Owner:"), 0, 3);
		form.add(ownerField, 1, 3);

		// buttons
		Button addButton = new Button("Add Property");
		Button showAllButton = new Button("Show All Properties");
		Button totalButton = new Button("Show Total Rent");

		addButton.setOnAction(e -> addProperty());
		showAllButton.setOnAction(e -> showAllProperties());
		totalButton.setOnAction(e -> showTotalRent());

		HBox buttonBox = new HBox(10, addButton, showAllButton, totalButton);

		// message label and output area
		messageLabel = new Label("Enter a property and click Add Property.");

		outputArea = new TextArea();
		outputArea.setEditable(false);
		outputArea.setPrefHeight(220);

		Label programmerLabel = new Label("Programmer: Javier Johnson");

		// put everything in a VBox
		VBox root = new VBox(12, titleLabel, form, buttonBox, messageLabel, outputArea, programmerLabel);
		root.setPadding(new Insets(15));

		Scene scene = new Scene(root, 760, 540);
		primaryStage.setTitle("Property Management Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Runs when "Add Property" is clicked.
	 * Checks the input, then creates a Property and adds it to the company.
	 */
	private void addProperty() {
		String name = nameField.getText().trim();
		String city = cityField.getText().trim();
		String rentText = rentField.getText().trim();
		String owner = ownerField.getText().trim();

		// validation: no empty fields
		if (name.equals("") || city.equals("") || rentText.equals("") || owner.equals("")) {
			messageLabel.setText("Error: Please fill in all four fields.");
			return;
		}

		// validation: rent has to be a positive number
		if (!isValidRent(rentText)) {
			messageLabel.setText("Error: Rent must be a number 0 or greater (example: 1200.50).");
			return;
		}

		double rent = Double.parseDouble(rentText);
		Property newProperty = new Property(name, city, rent, owner);
		int index = company.addProperty(newProperty);

		if (index == -1) {
			messageLabel.setText("Error: The company is full. It can only hold "
					+ ManagementCompany.MAX_PROPERTIES + " properties.");
		} else {
			messageLabel.setText("Property \"" + name + "\" was added at index " + index
					+ ". (" + company.getPropertyCount() + " of "
					+ ManagementCompany.MAX_PROPERTIES + " properties)");
			clearFields();
		}
	}

	/**
	 * Runs when "Show All Properties" is clicked.
	 * Shows the company's toString() in the output area.
	 */
	private void showAllProperties() {
		outputArea.setText(company.toString());
		messageLabel.setText("Showing all properties.");
	}

	/**
	 * Runs when "Show Total Rent" is clicked.
	 * Shows the total rent of all properties in the output area.
	 */
	private void showTotalRent() {
		outputArea.setText("Total Rent for " + company.getName() + ": $"
				+ String.format("%.2f", company.totalRent())
				+ "\nNumber of Properties: " + company.getPropertyCount());
		messageLabel.setText("Showing total rent.");
	}

	/**
	 * Checks if the rent text is a valid number that is 0 or greater.
	 * It is valid if it only has digits and at most one decimal point.
	 * (A minus sign is not allowed, so negative numbers are not valid.)
	 */
	private boolean isValidRent(String text) {
		int digitCount = 0;
		int dotCount = 0;

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c >= '0' && c <= '9') {
				digitCount++;
			} else if (c == '.') {
				dotCount++;
			} else {
				return false;   // any other character makes it invalid
			}
		}

		return digitCount > 0 && dotCount <= 1;
	}

	/**
	 * Clears all of the text fields after a property is added.
	 */
	private void clearFields() {
		nameField.clear();
		cityField.clear();
		rentField.clear();
		ownerField.clear();
	}

	/**
	 * Main method that launches the JavaFX application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
