package inheritance;

public class CustomerTest1 {

	public static void main(String[] args) {
//		Customer customerLee = new Customer();
//		customerLee.setCustomerID(10100);
//		customerLee.setCustomerName("Lee");
		
		// ���� Ŭ������ �����ɶ� ����Ŭ������ ���� �����ȴ�.
		// �� �޸𸮿� ���� Ŭ���� �ν��Ͻ��� ���� �����ǰ�, ���� Ŭ���� �ν��Ͻ��� ������
		VIPCustomer customerKim = new VIPCustomer(10101, "Kim", 100);
		// VIPCustomer() �������� ȣ��� �ν��Ͻ��� ��� �����Ǿ�����
		// Ÿ���� Customer�̹Ƿ� ���� �� �� �ִ� ������ �޼���� Customer ������ �޼���� ���ѵ�
		
		customerKim.bonusPoint = 1000;
		
//		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
	}

}

// ���� Ŭ�������� ������ ����ȯ(��ĳ����)
// ���� Ŭ���� ������ ������ �����ϰ� ����Ŭ���� �ν��Ͻ��� ������ �� ����
// ���� Ŭ������ ���� Ŭ������ Ÿ���� �����ϰ� �����Ƿ� ���� Ŭ������ ������ ����ȯ�� ����