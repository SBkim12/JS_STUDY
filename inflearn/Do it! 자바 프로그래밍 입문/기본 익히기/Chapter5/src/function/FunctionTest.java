package function;

public class FunctionTest {
	
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		
		int sum = addNum(num1, num2);
		
		System.out.println(sum);
	}
	
	public static int addNum(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	//함수가 호출될 대 사용하는 메모리 - Stack(스택)
	//함수의 기능 수행이 끝나면 자동으로 반환 되는 메모리
}
