package arraylist;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(1001, "Lee");
		studentLee.addSbuject("국어", 100);
		studentLee.addSbuject("수학", 90);

		Student studentKim = new Student(1002, "Kim");
		studentKim.addSbuject("국어", 100);
		studentKim.addSbuject("수학", 90);
		studentKim.addSbuject("영어", 80);
		
		studentKim.showStudentInfo();
		System.out.println("============================");
		studentLee.showStudentInfo();
	}

}
