package thisex;

class Birthday{
	int day;
	int month;
	int year;
	
	public void setYear(int year) {
		this.year= year; 
	}
	// this를 생략하게 되면 year는 파라미터로 사용되는 year로 인식된다.
	
	public void printThis() {
		System.out.println(this);
	}
}

public class ThisExample {

	public static void main(String[] args) {
		
		Birthday b1 = new Birthday();
		Birthday b2 = new Birthday();
		
		System.out.println(b1);
		b1.printThis(); //현재 자기 인스턴스의 주소값 출력

		System.out.println(b2);
		b2.printThis(); //현재 자기 인스턴스의 주소값 출력
		
		
	}

}
