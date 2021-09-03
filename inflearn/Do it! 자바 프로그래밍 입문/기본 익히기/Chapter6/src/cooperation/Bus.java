package cooperation;

public class Bus extends Trans {
	private int busNumber;
	
	public Bus(int busNumber) {
		this.busNumber =busNumber;
	}
	
	
	public void showInfo() {
		System.out.println("버스" + busNumber + "번의 승객은 " + super.getPassengerCount() + "명이고, 수입은 " + super.getMoney() + "입니다.");
	}
}
