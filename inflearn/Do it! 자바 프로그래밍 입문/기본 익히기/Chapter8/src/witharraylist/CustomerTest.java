package witharraylist;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerLee = new Customer(10010, "�̼���");
		Customer customerKim = new Customer(10011, "������");
		Customer customerShin = new GoldCustomer(10012, "�Ż��Ӵ�");
		Customer customerYul = new GoldCustomer(10013, "������");
		Customer customerHong = new VIPCustomer(10014, "ȫ�浿", 12345);
	
		customerList.add(customerHong);
		customerList.add(customerKim);
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerYul);
		
		System.out.println("=========    ������ ��� =========");

		for(Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}
		
		System.out.println("=========   �������� ���ʽ� ����Ʈ ��� =========");
		
		int price = 10000;
		for(Customer customer : customerList) {
			
			int cost = customer.calcPrice(price);
			
			System.out.println(customer.getCustomerName()+"���� "+cost+"�� �����߽��ϴ�.");
			System.out.println(customer.showCustomerInfo());
		}
		
	}
	
}
