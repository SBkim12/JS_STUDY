package cooperation;

public abstract class Trans {
	
	private int passengerCount;
	private int money;
	
	public void take(int money) {
		passengerCount++;
		this.money += money;
	}

	public int getPassengerCount() {
		return passengerCount;
	}


	public int getMoney() {
		return money;
	}

	
}
