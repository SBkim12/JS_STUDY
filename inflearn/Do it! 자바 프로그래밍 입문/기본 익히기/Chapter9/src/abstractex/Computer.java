package abstractex;

public abstract class Computer {
	
	public abstract void display();
	public abstract void typing();
	
	public void tunrOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void tunrOff() {
		System.out.println("전원을 끕니다.");
	}
}
