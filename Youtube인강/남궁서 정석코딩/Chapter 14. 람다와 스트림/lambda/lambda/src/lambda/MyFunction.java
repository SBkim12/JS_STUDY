package lambda;

@FunctionalInterface // 함수형 인터페이스는 단 하나의 춧아 메서드만 가져야 함(이 어노테이션을 사용함으로 써 체크해줌)
public interface MyFunction {
//	public abstract int max(int a, int b);
	int max(int a, int b);
}

//함수형 인터페이스 - 단 하나의 추상 메서드만 선언된 인터페이스