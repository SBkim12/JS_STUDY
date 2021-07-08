package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	//@Autowired(required = false) //xml�� exam2��� ��ü�� ��� ���� ����
	@Autowired
	//@Qualifier("exam2") // -> �⺻ �����ڰ� ȣ���(�⺻�����ھ����� ���� �߻�)
	private Exam exam;
	
	//�⺻ ������
	public InlineExamConsole() {
		System.out.println("consturctor");
	}
	
	//�����ε� 
	//@Autowired
	//@Qualifier("exam2") //�����ε� ����϶��� �Ķ���Ϳ��� ���� ex)InlineExamConsole(@Qualifier("exam2")Exam exam)
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
	
	
	
	//@Autowired  // �ڵ����� ��ü ����, ���� ����. Exam�����ϴ°��� �ڵ����� ã�Ƽ� ���ε�.   xml��  <property name="exam" ref="exam"/>�� ���� ���� 
	//@Qualifier("exam2") // xml���� ������ id��(������)�� ��ġ������  
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
