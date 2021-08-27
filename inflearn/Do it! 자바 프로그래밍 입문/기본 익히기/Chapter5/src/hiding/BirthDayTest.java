package hiding;

class BirthDay{
	//private 접근 제어자
	// 멤버 변슈나 메서드를 외부에서 사용하지 못하도록 하여 오률 줄일 수 있음
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		
		if(month==2) {
			if(day <1 || day >28) {
				System.out.println("날짜 오류입니다.");
			}else {
				this.day = day;
			}
		}
		
	}
	public int getMonth() {
		
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}

public class BirthDayTest{
	
	public static void main(String[] args) {
		
		BirthDay day = new BirthDay();

		day.setMonth(2);
		day.setDay(30);
		day.setYear(2020);
		
	}
}