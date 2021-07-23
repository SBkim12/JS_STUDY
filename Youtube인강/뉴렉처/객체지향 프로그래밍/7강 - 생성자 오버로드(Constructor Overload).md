두개 이상의 생성자

오버로드란 - 똑같은 기능을 인자를 다르게해서 편의를 도모하는 것

class ExamList
{
	private Exam[] exams
	private int current;
	
	/*
	public ExamList(){
		exams = new Exam[3];
		current = 0;
	}
	*/
	//생성자의 중복 제거
	public ExamList(){
		this(3);
	}

	
	public ExamList(int size){
		exams = new Exam[size];
		current = 0;
	}

}

=>
두 가지 방식으로 생성자를 호출 가능
new ExamList();
new ExamList(10);



생성자를 하나도 정의하지 않는다면
=> 컴파일러가 컴파일할때 기본생성자를 자동생성함(참조변수는 null, 값변수는 0)

기본 생성자 X 오버로드만 구현시
=> 컴파일러가 기본생성자를 생성하지 않음(생성자가 하나도 없을경우에만 생성함), 오버로드만 의도적으로 만들때만 사용함


