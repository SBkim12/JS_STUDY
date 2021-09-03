package cooperation;

public class Subway extends Trans{
	private int lineNumber;
	
	
	public Subway(int lineNumber) {
		this.lineNumber =lineNumber;
	}
	
	
	public void showInfo() {
		System.out.println("지하철" + lineNumber + "번의 승객은 " + super.getPassengerCount() + "명이고, 수입은 " + super.getMoney() + "입니다.");
	}

	
}
