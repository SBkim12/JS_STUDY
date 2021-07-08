package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam(1,1,1,1);
		
		//��ٸ� ������ �����ִ� proxy
		Exam proxy = (Exam) Proxy.newProxyInstance(
				NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//���� ����
						long start = System.currentTimeMillis();
						
						//invoke(������ü, ���� ��ü�� �Ķ����)
						Object result = method.invoke(exam, args);
						
						//���� �ð� ���
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//���� ����
						long end = System.currentTimeMillis();
						
						String message = (end - start) + "ms �ð� �ɷȽ��ϴ�." ;
						System.out.println(message);
						
						return result;
					}
				});
		//AOP ��� ��
		//System.out.printf("total is %d\n", exam.total());
		
		//AOP ��� �� 
		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("avg is %f\n", proxy.avg());
	}

}
