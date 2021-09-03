package witharraylist;

public class VIPCustomer extends Customer{
	
	private int agentID;
	private double saleRatio;
	
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		
//		System.out.println("VIPCustomer() 호출");
	}
	
	public VIPCustomer(int customerId, String customerName, int agentID) {
		super(customerId,customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
		
//		System.out.println("VIPCustomer(int, string) 호출");
	}
	
	public int calcPrice(int price) {
		bonusPoint += price *bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
	public int getAgentID() {
		return agentID;
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo() + "담당 상담원 아이디는 " + agentID +"입니다.";
	}
	
	
}
