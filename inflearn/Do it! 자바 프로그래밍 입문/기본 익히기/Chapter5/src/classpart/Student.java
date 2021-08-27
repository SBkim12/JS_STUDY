package classpart;


// �ϳ��� java���Ͽ� �ϳ��� Ŭ������ �δ� ���� ��Ģ�̳�, �������� Ŭ������ ���� �ִ� ��� public Ŭ������ �� �ϳ��̸�, public Ŭ������ �ڹ� ������ �̸��� �����ؾ���
public class Student {
	
	private int studentId;
	private String studentName;
	private int grade;
	private String address;
	
	//�ϳ��� Ŭ�������� �ݵ�� ��� �ϳ� �̻��� �����ڰ� ����
	// ���α׷��Ӱ� �����ڸ� ��� ���� ������ default ������ �����ڰ� �ڵ����� ����(�����Ϸ��� �־���)
	//Default �����ڴ� �Ű� ����, �����ΰ� ����
	// ����, �Ű������� �ִ� �����ڸ� �߰��ϸ� Default �����ڴ� �������� ����
	public Student() {} 
	
	//�����ڴ� �ν��Ͻ��� �ʱ�ȭ �� ���� ��ɾ� ����
	//�������� �̸��� �� Ŭ������ �̸��� ����
	// �����ڴ� �޼ҵ尡 �ƴ�. ��ӵ��� ������, ���� ���� ����
	//������ �����ε�(Constructor overload)
	public Student(int id, String name) {
		studentId= id;
		studentName = name;
	} 
	
	public void showStudentInfor() {
		System.out.println(studentName + "," + address);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public static void main(String[] args) {
		
		int i = 10;
		
		Student studentLee = new Student(); // ������ ������ Ÿ�� - Student, ������ ���� - studnet Lee , new ������
		studentLee.setStudentName("�̼���");
		studentLee.setGrade(100);
		studentLee.setAddress("����� �������� ���ǵ���");
		
		Student studentKim = new Student(); 
		studentKim.setStudentName("������");
		studentKim.setGrade(101);
		studentKim.setAddress("�̱� ��ȣ��");
		
		studentLee.showStudentInfor();
		studentKim.showStudentInfor();
		
		System.out.println(studentLee); // ������ - ������ �ν��Ͻ��� �޸� �ּҰ�
		System.out.println(studentKim);
		
		//�ϳ��� Ŭ���� �ڵ�κ��� �������� �ν��Ͻ��� ����
		//�ν��Ͻ��� ��(Heap) �޸𸮿� ������
		//������ �ν��Ͻ��� �ٸ� �޸𸮿� �ٸ� ���� ����
		//Garbage �ݷ��Ͱ� �� �޸𸮸� ��������
	}
	
}
