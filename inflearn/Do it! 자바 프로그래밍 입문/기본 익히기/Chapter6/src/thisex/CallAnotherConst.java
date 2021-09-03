package thisex;

//this의 역할
// 자신의 메모리를 가리킴
// 생성자에서 다른 생성자를 호출함
// 자신의 주소를 반환함  

class Person{
	
	String name;
	int age;
	
	
	public Person() {
		this("이름없음", 1);
		//생성자에서 this(다른생성자) 앞에 어떠한 statement도 올수 없다.(아직 객체가 제대로 생성되지 않았기 때문)
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person returnSelf() {
		return this;
	}
	//자기자신으로 반환형을 잡고 this를 리턴하면 주소값을 반환한다.
}

public class CallAnotherConst {
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		System.out.println(p1.name);
		
		System.out.println(p1.returnSelf());
	}

}
	
