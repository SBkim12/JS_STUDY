package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* ���������� �����ϴ� ������� �ڵ带 ����
		Exam exam = new lecExam();
		//ExamConsole console = new InlineExamConsole(exam); //DI
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		*/
		
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("spring/di/setting.xml");
		 */
		
		// Java Configuration ���� ����(����)
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		// Java Configuration ���� ����(����)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ctx.register(AppConfig.class, OtherConfig.class):
		ctx.register(NewlecDIConfig.class);
		ctx.refresh();
		
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) ctx.getBean("console"); 
		//ExamConsole console = context.getBean(ExamConsole.class); //Ÿ�Կ� �´� �༮�� ã����
		console.print();
		
		//List<Exam> exams = (List<Exam>) context.getBean("exams"); //new ArrayList<>();
		//exams.add(new lecExam(1,1,1,1)); //�������Ͽ��� �⺻ �������� ������ �־���
		
		
//		for(Exam e : exams) {
//			System.out.println(e);
//		}
	}

}
