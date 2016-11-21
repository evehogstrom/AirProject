package myair;


public class Customer {

	private static int customerId;
	private String firstName;
	private String sureName;
	private boolean foodStatus;

	public Customer(String firstName, String sureName) {
		this.firstName = firstName;
		this.sureName = sureName;
		customerId++;
		foodStatus = false;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSureName() {
		return sureName;
	}

	public void setFoodStatus(boolean foodStatus) {
		this.foodStatus = foodStatus;
	}

	public boolean foodStatusCheck() {
		return this.foodStatus;
	}
	
	@Override
	public String toString() {
		if (foodStatus == false)
			return firstName+ " " + sureName + " " + "Food[no]";
		else
			return firstName + " " + sureName + " " + "Food[yes]";
	}
}
