package inheritance;

public class Customer {
	
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	protected double bonusRatio;
	
//	���� ������ ���ü�
/*				�ܺ�Ŭ����	����Ŭ����	������Ű��	����Ŭ����
 *	public		O		O		O		O
 *	protected	X		O		O		O 
 * 	default		X		X		O		O
 * 	private		X		X		X		O
 */
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
		System.out.println("Customer() ȣ��");
	}
	
	public Customer(int customerId, String customerName) {
		this.customerID = customerId;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
//		System.out.println("VIPCustomer(int, Strng) ȣ��");
	}
	
	public int calcPrice(int price) {
		bonusPoint += price *bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "���� ����� " + customerGrade + "�̸�, ���ʽ� ����Ʈ��" + bonusPoint + "�Դϴ�.";
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
		bonusRatio = bonusRatio;
	}
	
	
}

