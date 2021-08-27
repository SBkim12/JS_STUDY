package lambda;

public class lambda1 {

	public static void main(String[] args) {
		//람다식은 익명함수가 아니라 익명 객체이다.
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) { //오버라이딩 - 접근제어자는 좁게 못바꾼다
//				return a > b? a: b;
//			}
//		};
		
		//람다식 변경
		// 람다식( 익명 객체 )을 다루기 위한 참조 변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f = (a,b) -> a > b? a : b;  //람다식. 익명객체

		
		int value = f.max(3, 5); // OK. MyFunction에 max()가 있음
		//함수형 인터페이스 타입의 참조변수로 람다식을 참조할 수 있음(단, 함수형 인터페이스의 메서드와 람다식의 매개변수 개수와 반환타입이 일치해야함)
		
		System.out.println("value="+value);
	}
	
	
	
	
	//람다란 익명의함수(이름이 없고 내용만 잇는 함수), 함수를 정의하는 간펺나 방법
	
	//람다식 작성방법
	//메섣의 이름과 반환 타입을 제거하고 '->'를 블록{} 앞에 추가한다.
	//반환 값이 잇는 경우, 식이나 값ㅁ나 적고 return문 생략 가능(끝에 ';' 안 붙힘)
	// 매개변수의 타입이 추론 가능하면 생략 가능
	

	//주의 사항
	// 매개변수가 하나인 경우, 괄호() 생략 가능(타입이 없을 때 만)
	// 블록 안의 문장이 하나뿐일때, 괄호{} 생략 가능(끝에 ';' 안 붙힘)
}
