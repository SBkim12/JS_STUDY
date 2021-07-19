인스턴스(Instance) 메소드

void main()
{
	list = new ExamList();
	ExamList.inputList(list);
	ExamList.printList(list);
	ExamList.saveList(list);
}
리스트를 이용한 처리

=>
void main()
{
	list= new ExamList();
	list.inputList();
	list.printList();
	list.saveList();
}
list(야).입력(해)()
list(야).출력(해)()
list(야).저장(해)()  => 책임전가(주체 변경)



ex)
기존 함수의 인스턴스 전달
public static void main(String[] args){
	ExamList list = new ExamList();
	ExamList.inputList(list);
}

class ExamList{
	// static이 있으면 함수
	public static void inpustList(ExamList list){
		list.exams[list.current]= new Exam();
	}
}

새로운 함수의 인스턴스 전달
public static void main(String[] args){
	ExamList list = new ExamList();
	list.inputList();
}

class ExamList{
	//static이 없으면 인스턴스의 메소드
	public void inputList(){
		this.exams[this.current] = new Exam();
	}
}

=> static과 parameter의 차이
	this는 생략이 가능하면 생략!