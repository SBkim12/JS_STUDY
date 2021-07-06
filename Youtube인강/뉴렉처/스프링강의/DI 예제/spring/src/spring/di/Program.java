package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.lecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new lecExam();
		//ExamConsole console = new InlineExamConsole(exam); //DI
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		*/
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		
		//ExamConsole console = (ExamConsole) context.getBean("console");
		ExamConsole console = context.getBean(ExamConsole.class); //타입에 맞는 녀석을 찾아줌
		console.print();
		
		List<Exam> exams = (List<Exam>) context.getBean("exams"); //new ArrayList<>();
		//exams.add(new lecExam(1,1,1,1)); //설정파일에서 기본 설정으로 파일을 넣어줌
		
		
		for(Exam e : exams) {
			System.out.println(e);
		}
	}

}
