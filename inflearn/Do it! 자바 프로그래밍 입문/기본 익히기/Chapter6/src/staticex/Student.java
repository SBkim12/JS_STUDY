package staticex;

public class Student {
	
	// static ������ �ν��Ͻ��� ������ �븶�� �ٸ� �޸𸮸� ������ ���� �ƴ϶�, ���α׷��� �޸𸮿� ���� �ɶ� ������ ������ �޸𸮿� ������
	// �ٶ�, �ν��Ͻ��� ������ ������� Ŭ���� �̸����� ���� ���� ��
	private static int serialNum = 10000;
	// ��� Student Instance�� ���� �ϳ��� ������ �����ǰ� �̷��� ������ class ������ �Ѵ�.
	// �ʹ� ū �޸� ����� �����ؾߵȴ�.
	
	
	int studentId;
	String studentName;
	
	public Student() {
		serialNum++;
		studentId = serialNum;
	}

	public static int getSerialNum() {
		int i = 10; //��������
		
		i++;
		System.out.println(i);
		
		// �����Ǵ� �ñⰡ �޶� �ν��Ͻ� ������ ����Ҽ� ����(�������� �ʾҴµ� ��û�ؼ� ���� �߻�)
		//studentName = "ȫ�浿"; //��� ����, �ν��Ͻ� ����
		
		return serialNum; // Ŭ���� ����, Static ����
	}
	
}


//���α׷����� ���� �޸�

// ���޸� : �ν��Ͻ��� �����ɶ� ���� �����Ǵ� ���� �޸� 
// ���� �޸�  : ���������� ���� �޸�
// ������ ���� : static or literal ���� �ִ� �޸�