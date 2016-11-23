package myair;


public class Customer {

	private static int customerId;
	private String firstName;
	private String surName;
	private boolean foodStatus;

	public Customer(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
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
		return surName;
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
			return firstName+ " " + surName + " " + "Food[no]";
		else
			return firstName + " " + surName + " " + "Food[yes]";
	}
}
