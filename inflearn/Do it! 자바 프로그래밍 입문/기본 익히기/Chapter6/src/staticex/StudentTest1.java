package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		
		System.out.println(Student.getSerialNum());
		
		Student studentJ = new Student();
		System.out.println(studentJ.studentId);
		
		Student studentT = new Student();
		System.out.println(studentT.studentId);
		
		System.out.println(Student.getSerialNum()); // static���� �Ҵ�� ���� Ŭ���� �̸��� ����
		
		
	}

}
