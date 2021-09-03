package singleton;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		
		
		Company c1 = Company.getInstance();
		Company c2 = Company.getInstance();
		
		//sCompany c3 = new Company(); //error
		
		
		System.out.println(c1==c2);// true
		
		//=> 싱글톤 만들어 보라는 문제(문제 이해 필요))
		
		Calendar cal = Calendar.getInstance();
	}

}
