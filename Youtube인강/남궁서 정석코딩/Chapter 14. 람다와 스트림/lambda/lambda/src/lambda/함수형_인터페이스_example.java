package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 함수형_인터페이스_example {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaaa");
		
//		Collections.sort(list, new Comparator<String>() {
//			public int compare (String s1, String s2) {
//				return s2.compareTo(s1);
//			}
//		});
		
		//람다식 단축
		
		Collections.sort(list, (s1,s2) -> s2.compareTo(s1));
	}
	
	
	
}
