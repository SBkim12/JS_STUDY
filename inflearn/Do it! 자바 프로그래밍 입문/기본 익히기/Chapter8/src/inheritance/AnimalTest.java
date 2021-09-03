package inheritance;

class Animal{
	 public void move() {
		 System.out.println("동물이 움직입니다.");
	 }
}

class Human extends Animal{
	public void move() {
		 System.out.println("사람이 두발로 걷습니다.");
	 }
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}
class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이가 네발로 뜁니다.");
	}
	
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}
class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 하늘을 날읍니다.");
	}
	
	public void flying() {
		System.out.println("하늘을 날아갑니다.");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		
		AnimalTest test = new AnimalTest();
		test.moveAnimal(new Human());
		test.moveAnimal(new Tiger());
		test.moveAnimal(new Eagle());
		
		//Animal animal =new Human();
	}
	
	// 다형성 구현
	public void moveAnimal(Animal animal ) { // 매개변수의 자료형이 상위 클래스
		animal.move();//재정의된 메서드가 호출됨
		
		//다운캐스팅 (오버라이딩으로 해결이 안됬을 경우 사용)
		if(animal instanceof Human) {
			Human human = (Human)animal;
			human.readBook();
		}else if(animal instanceof Tiger) {
			Tiger tiger = (Tiger)animal;
			tiger.hunting();
		}else if(animal instanceof Eagle) {
			Eagle eagle = (Eagle)animal;
			eagle.flying();
		}else {
			System.out.println("지원되지 않는 기능입니다.");
		}
		
	}

}


// 다형성(polymorphism)
// 하나의 코드가 여러가지 자료형으로 구현되어 실행되는 것
// 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나
// 유연성, 재활용성, 유지보수성에 기본이 되는 특징

//다운 캐스팅 - instanceof
// 하위클래스가 상위 클래스로 형 변환 되는 것은 묵시적으로 이루어짐
// 다시 원래 자료형인 하위 클래스로 형 변호나 하려면 명시적으로 다운 캐스팅 해야함
// 이대 원래 인스턴스의 타입을 체크하는 예약어가 instanceof