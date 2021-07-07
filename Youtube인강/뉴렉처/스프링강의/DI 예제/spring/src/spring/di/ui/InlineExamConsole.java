package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	//@Autowired(required = false) //xml에 exam2라는 객체가 없어도 실행 가능
	@Autowired
	//@Qualifier("exam2") // -> 기본 생성자가 호출됨(기본생성자없으면 오류 발생)
	private Exam exam;
	
	//기본 생성자
	public InlineExamConsole() {
		System.out.println("consturctor");
	}
	
	//오버로드 
	//@Autowired
	//@Qualifier("exam2") //오버로딩 방식일때는 파라미터에서 지정 ex)InlineExamConsole(@Qualifier("exam2")Exam exam)
	public InlineExamConsole(@Qualifier("exam2")Exam exam) {
		System.out.println("overloaded consturctor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam== null) 
			System.out.printf("total is %d, avg is %f\n", 0,0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	
	
	//@Autowired  // 자동으로 객체 연결, 세팅 해줌. Exam참조하는것을 자동으로 찾아서 바인딩.   xml의  <property name="exam" ref="exam"/>과 같은 역할 
	//@Qualifier("exam2") // xml파일 세팅의 id값(변수명)을 일치시켜줌  
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
