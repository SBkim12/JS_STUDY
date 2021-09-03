package witharraylist;

public class Customer {
	
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	protected double bonusRatio;
	
//	접근 제한자 가시성
/*				외부클래스	하위클래스	동일패키지	내부클래스
 *	public		O		O		O		O
 *	protected	X		O		O		O 
 * 	default		X		X		O		O
 * 	private		X		X		X		O
 */
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
		System.out.println("Customer() 호출");
	}
	
	public Customer(int customerId, String customerName) {
		this.customerID = customerId;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
//		System.out.println("VIPCustomer(int, Strng) 호출");
	}
	
	public int calcPrice(int price) {
		bonusPoint += price *bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는" + bonusPoint + "입니다.";
	}
	

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getbonusRatio() {
		return bonusRatio;
	}

	public void setbonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
}

//IS-A 관계 (is a relationship : inheritance)
// 일반적인 개념과 구체적인 개념과의 관계
// 상위 클래스 : 일반적인 개념 ex) 포유류
// 하위 클래스 : 구체적인 개념 ex) 사람, 원숭이, 고래
// 단순 코드 재사용하는 목적으로 사용하지 않음

//HAS-A관계 (composition) : 한 클래스가 다른 클래스를 소유하는 상황
// 코드 재사용의 한 방법으로 Student가 Subject를 포함한 관계
