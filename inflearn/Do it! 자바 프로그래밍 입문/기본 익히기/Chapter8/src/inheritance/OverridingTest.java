package inheritance;

public class OverridingTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer(100010,"LEE");
		int price = customerLee.calcPrice(10000);
		System.out.println("지불금액은 " + price + "이고, " + customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer(100010, "Kim", 100);
		price = customerKim.calcPrice(10000);
		System.out.println("지불금액은 " + price + "이고, " + customerKim.showCustomerInfo());
		
		Customer customerWho = new VIPCustomer(100010, "Who", 100);
		price = customerWho.calcPrice(10000);
		System.out.println("지불금액은 " + price + "이고, " + customerWho.showCustomerInfo());
		//묵시적 형 변환과 재정의 된 메서드 호출
		
		//가상 메서드(virtual method)
		// 프로그램에서 어떤 객체의 변수나 메서드의 참조는 그타입에 따라 이루어짐.
		// 가상의 메서드의 경우는 타입과 상관없이 실제 생성된 인스턴스의 메서드가 호출되는 원리
		// customerWho의 타입은 Customer이지만, 실제 생성된 인스턴스인 VIPCustomer 클래스의 calcPrice() 메서드가 호출됨
		
		Customer customerGold = new GoldCustomer();
		
	}

}
