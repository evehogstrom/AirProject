package myair;
public class Seat {

	private int seatNumber;
	private String seatClass;
	double seatPrice;
	private boolean reserved;

	public Seat(int seatNumber, String seatClass, double seatPrice) {
		this.seatNumber = seatNumber;
		this.seatClass = seatClass;
		this.seatPrice = seatPrice;
		reserved = false;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setReserved(boolean status) {
		this.reserved = status;
	}

	public boolean isReserved() {
		return this.reserved;
	}

	@Override
	public String toString() {
		if (reserved == false)
			return "Seat " + seatNumber + "-" + seatClass + "[]" + seatPrice;
		else
			return "Seat " + seatNumber + "-" + seatClass + "[Reserved]";

	}

}
