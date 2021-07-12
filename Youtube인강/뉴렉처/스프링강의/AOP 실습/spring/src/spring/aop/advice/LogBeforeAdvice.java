package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//앞부분에 실행될 내용만 넣어주면 됨
		System.out.println("앞에서 실행될 로직");
		//method = 함수의 이름
		//args = 함수의 파라미터
		//target = 타겟의 객체
	}
	
}
