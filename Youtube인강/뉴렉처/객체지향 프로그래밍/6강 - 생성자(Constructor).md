생성자 : 초기화를 위한 특별한 함수
생성자의 조건 : 	
	1.객체가 생성 되자 마자 무조건 제일 먼저 실행되어야 만 한다.
	2. 생성될 때 단 한번만 실행 되어야 한다.
 	cf) 생성자는 함수명이 없다.
	    정의할 때의 함수명은 초기화 할 객체를 한정하기 위한 형식명칭이다.


ex)
public class Program{
	public static void main(String[] args){
		ExamList list  = new ExamList();
		list.init(); //생성자가 여러번 호출 될수 있음
		
		...
	}
}

public class ExamList{
	private Exam[] exams;
	private int current;
	
	public void init(){
		exams = new Exam[3];
		current = 0;	
	}
}

=>
//생성자의 여러번 호출을 방지 할수 잇음

public class Program{
	public static void main(String[] args){
		ExamList list  = new ExamList();
		
		...
	}
}

public class ExamList{
	private Exam[] exams;
	private int current;
	
	public ExamList(){
		exams = new Exam[3];
		current = 0;	
	}
}