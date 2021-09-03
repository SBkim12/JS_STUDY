package inheritance;

class Animal{
	 public void move() {
		 System.out.println("������ �����Դϴ�.");
	 }
}

class Human extends Animal{
	public void move() {
		 System.out.println("����� �ι߷� �Ƚ��ϴ�.");
	 }
	
	public void readBook() {
		System.out.println("����� å�� �н��ϴ�.");
	}
}
class Tiger extends Animal{
	public void move() {
		System.out.println("ȣ���̰� �׹߷� �ݴϴ�.");
	}
	
	public void hunting() {
		System.out.println("ȣ���̰� ����� �մϴ�.");
	}
}
class Eagle extends Animal{
	public void move() {
		System.out.println("�������� �ϴ��� �����ϴ�.");
	}
	
	public void flying() {
		System.out.println("�ϴ��� ���ư��ϴ�.");
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
	
	// ������ ����
	public void moveAnimal(Animal animal ) { // �Ű������� �ڷ����� ���� Ŭ����
		animal.move();//�����ǵ� �޼��尡 ȣ���
		
		//�ٿ�ĳ���� (�������̵����� �ذ��� �ȉ��� ��� ���)
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
			System.out.println("�������� �ʴ� ����Դϴ�.");
		}
		
	}

}


// ������(polymorphism)
// �ϳ��� �ڵ尡 �������� �ڷ������� �����Ǿ� ����Ǵ� ��
// ��������, ��Ӱ� ���Ҿ� ��ü���� ���α׷����� ���� ū Ư¡ �� �ϳ�
// ������, ��Ȱ�뼺, ������������ �⺻�� �Ǵ� Ư¡

//�ٿ� ĳ���� - instanceof
// ����Ŭ������ ���� Ŭ������ �� ��ȯ �Ǵ� ���� ���������� �̷����
// �ٽ� ���� �ڷ����� ���� Ŭ������ �� ��ȣ�� �Ϸ��� ��������� �ٿ� ĳ���� �ؾ���
// �̴� ���� �ν��Ͻ��� Ÿ���� üũ�ϴ� ���� instanceof