package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {
	
	//사용하려는 오류에 맞춰서 만들면 됩니다  ex)IllegalArgumentException
	public void afterThrowing(IllegalArgumentException e)throws Throwable{
		System.out.println("예외가 발생하였습니다. : " +e.getMessage());
	}
}
