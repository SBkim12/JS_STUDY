package staticex;

public class Student {
	
	// static 변수는 인스턴스가 생성될 대마다 다른 메모리를 가지는 것이 아니라, 프로그램이 메모리에 적재 될때 데이터 영역의 메모리에 생성됨
	// 다라서, 인스턴스의 생성과 관계없이 클래스 이름으로 직접 참조 함
	private static int serialNum = 10000;
	// 모든 Student Instance에 대해 하나의 변수로 유지되고 이러한 변수를 class 변수라 한다.
	// 너무 큰 메모리 사용은 지양해야된다.
	
	
	int studentId;
	String studentName;
	
	public Student() {
		serialNum++;
		studentId = serialNum;
	}

	public static int getSerialNum() {
		int i = 10; //지역변수
		
		i++;
		System.out.println(i);
		
		// 생성되는 시기가 달라서 인스턴스 변수는 사용할수 업음(생성지도 않았는데 요청해서 오류 발생)
		//studentName = "홍길동"; //멤버 변수, 인스턴스 변수
		
		return serialNum; // 클래스 변수, Static 변수
	}
	
}


//프로그램에서 쓰는 메모리

// 힙메모리 : 인스턴스가 생성될때 마다 생성되는 동적 메모리 
// 스택 메모리  : 지역변수가 쓰는 메모리
// 데이터 영역 : static or literal 등이 있는 메모리