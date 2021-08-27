package classpart;


// 하나의 java파일에 하나의 클래스를 두는 것이 원칙이나, 여러개의 클래스가 같이 있는 경우 public 클래스는 단 하나이며, public 클래스와 자바 파일의 이름은 동일해야함
public class Student {
	
	private int studentId;
	private String studentName;
	private int grade;
	private String address;
	
	//하나의 클래스에는 반드시 적어도 하나 이상의 생성자가 존재
	// 프로그래머가 생성자를 기술 하지 않으면 default 값으로 생성자가 자동으로 생김(컴파일러가 넣어줌)
	//Default 생성자는 매개 변수, 구현부가 없음
	// 만약, 매개변수가 있는 생성자를 추가하면 Default 생성자는 제공되지 않음
	public Student() {} 
	
	//생성자는 인스턴스를 초기화 할 때의 명령어 집합
	//생성자의 이름은 그 클래스의 이름과 같음
	// 생성자는 메소드가 아님. 상속되지 않으며, 리턴 값은 없음
	//생성자 오버로드(Constructor overload)
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
		
		Student studentLee = new Student(); // 참조형 데이터 타입 - Student, 참좋형 변수 - studnet Lee , new 생성자
		studentLee.setStudentName("이순신");
		studentLee.setGrade(100);
		studentLee.setAddress("서울시 영등포구 여의도동");
		
		Student studentKim = new Student(); 
		studentKim.setStudentName("김유신");
		studentKim.setGrade(101);
		studentKim.setAddress("미국 산호세");
		
		studentLee.showStudentInfor();
		studentKim.showStudentInfor();
		
		System.out.println(studentLee); // 참조값 - 생성된 인스턴스의 메모리 주소값
		System.out.println(studentKim);
		
		//하나의 클래스 코드로부터 여러개의 인스턴스를 생성
		//인스턴스는 힙(Heap) 메모리에 생성됨
		//각각의 인스턴스는 다른 메모리에 다른 값을 가짐
		//Garbage 콜렉터가 힙 메모리를 관리해줌
	}
	
}
