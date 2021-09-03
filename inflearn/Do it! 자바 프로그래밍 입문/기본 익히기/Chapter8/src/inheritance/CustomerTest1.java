package inheritance;

public class CustomerTest1 {

	public static void main(String[] args) {
//		Customer customerLee = new Customer();
//		customerLee.setCustomerID(10100);
//		customerLee.setCustomerName("Lee");
		
		// 하위 클래스가 생성될때 상위클래스가 먼저 생성된다.
		// 힙 메모리에 상위 클래스 인스턴스가 먼저 생성되고, 하위 클래스 인스턴스가 생성됨
		VIPCustomer customerKim = new VIPCustomer(10101, "Kim", 100);
		// VIPCustomer() 생성자의 호출로 인스턴스는 모두 생성되었지만
		// 타입이 Customer이므로 접근 할 수 있는 변수나 메서드는 Customer 변수와 메서드로 제한됨
		
		customerKim.bonusPoint = 1000;
		
//		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
	}

}

// 상위 클래스로의 묵시적 형변환(업캐스팅)
// 상위 클래스 형으로 변수를 선언하고 하위클래스 인스턴스를 생성할 수 있음
// 하위 클래스는 상위 클래스의 타입을 내포하고 있으므로 상위 클래스로 묵시적 형변환이 가능