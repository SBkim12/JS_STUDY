package cooperation;

public class Bus extends Trans {
	private int busNumber;
	
	public Bus(int busNumber) {
		this.busNumber =busNumber;
	}
	
	
	public void showInfo() {
		System.out.println("����" + busNumber + "���� �°��� " + super.getPassengerCount() + "���̰�, ������ " + super.getMoney() + "�Դϴ�.");
	}
}
