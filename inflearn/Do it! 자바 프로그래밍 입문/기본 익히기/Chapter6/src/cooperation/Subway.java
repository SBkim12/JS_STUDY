package cooperation;

public class Subway extends Trans{
	private int lineNumber;
	
	
	public Subway(int lineNumber) {
		this.lineNumber =lineNumber;
	}
	
	
	public void showInfo() {
		System.out.println("����ö" + lineNumber + "���� �°��� " + super.getPassengerCount() + "���̰�, ������ " + super.getMoney() + "�Դϴ�.");
	}

	
}
