package arraylist;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(1001, "Lee");
		studentLee.addSbuject("����", 100);
		studentLee.addSbuject("����", 90);

		Student studentKim = new Student(1002, "Kim");
		studentKim.addSbuject("����", 100);
		studentKim.addSbuject("����", 90);
		studentKim.addSbuject("����", 80);
		
		studentKim.showStudentInfo();
		System.out.println("============================");
		studentLee.showStudentInfo();
	}

}
