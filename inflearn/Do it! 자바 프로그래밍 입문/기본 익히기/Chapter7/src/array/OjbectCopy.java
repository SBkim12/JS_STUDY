package array;

public class OjbectCopy {

	public static void main(String[] args) {
		
		Book[] bookArray1 = new Book[3];
		Book[] bookArray2 = new Book[3];
		
		bookArray1[0] = new Book("�¹���1", "������");
		bookArray1[1] = new Book("�¹���2", "������");
		bookArray1[2] = new Book("�¹���3", "������");
		
		System.arraycopy(bookArray1, 0, bookArray2, 0, 3);
		//�迭 �����ϱ�
		//System.arraycopy(src, srcPos, dest, destPos, length);
		//src:������ �迭�̸�, src-pos:������ �迭�� ù��° ��ġ, dest:�ٿ����� ��� �迭 �̸�, destPos:�ٿ� �ֱ� ������ ù ��° ��ġ, length:src���� dest�� �ڷḦ ������ ��� ����
		
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		bookArray1[0].setBookName("����");
		bookArray1[0].setAuthor("�ڿϼ�");
		//���� ����(������ ����Ȱ��� �ƴ϶� �ּҰ��� ����)
		
		System.out.println("================");
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		//bookArray1�� �����ߴµ� ���� �ּҰ��� �����ϰ� �ִ� bookArray2�� ���� ������
		
		System.out.println("=====================");
		
		bookArray2[0] = new Book();
		bookArray2[1] = new Book();
		bookArray2[2] = new Book();
		//�ּҸ� ���Ӱ� �Ҵ�
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].setAuthor(bookArray1[i].getAuthor());
			bookArray2[i].setBookName(bookArray1[i].getBookName());
		}
		//�ּҰ��� �ƴ� ���븸 �����ͼ� ����
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray1[i].showBookInfo();
			bookArray2[i].showBookInfo();
			System.out.println("bookArray1["+i+"]   :  "+bookArray1[i]);
			System.out.println("bookArray2["+i+"]   :  "+bookArray2[i]);
		}
		//������ ������ �ٸ� �ּҰ��� ����
		
		String[] strArr = {"Java", "Android", "C"};
		
		for(String s : strArr) {
			System.out.println(s);
		}
		//���� for ��(enhanced for loop)
		//�迭 ����� ó������ ������ ��� ��Ҹ� ���� �Ҵ� ���� �ݺ���
	}
	
}
