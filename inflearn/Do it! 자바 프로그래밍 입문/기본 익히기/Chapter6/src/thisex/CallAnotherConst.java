package thisex;

//this�� ����
// �ڽ��� �޸𸮸� ����Ŵ
// �����ڿ��� �ٸ� �����ڸ� ȣ����
// �ڽ��� �ּҸ� ��ȯ��  

class Person{
	
	String name;
	int age;
	
	
	public Person() {
		this("�̸�����", 1);
		//�����ڿ��� this(�ٸ�������) �տ� ��� statement�� �ü� ����.(���� ��ü�� ����� �������� �ʾұ� ����)
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person returnSelf() {
		return this;
	}
	//�ڱ��ڽ����� ��ȯ���� ��� this�� �����ϸ� �ּҰ��� ��ȯ�Ѵ�.
}

public class CallAnotherConst {
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		System.out.println(p1.name);
		
		System.out.println(p1.returnSelf());
	}

}
	
