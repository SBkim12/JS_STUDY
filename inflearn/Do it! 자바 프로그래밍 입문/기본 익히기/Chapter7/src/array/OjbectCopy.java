package array;

public class OjbectCopy {

	public static void main(String[] args) {
		
		Book[] bookArray1 = new Book[3];
		Book[] bookArray2 = new Book[3];
		
		bookArray1[0] = new Book("태백산맥1", "조정래");
		bookArray1[1] = new Book("태백산맥2", "조정래");
		bookArray1[2] = new Book("태백산맥3", "조정래");
		
		System.arraycopy(bookArray1, 0, bookArray2, 0, 3);
		//배열 복사하기
		//System.arraycopy(src, srcPos, dest, destPos, length);
		//src:복사할 배열이름, src-pos:복사할 배열의 첫번째 위치, dest:붙여넣을 대상 배열 이름, destPos:붙여 넣기 시작할 첫 번째 위치, length:src에서 dest로 자료를 복사할 요소 개수
		
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		
		bookArray1[0].setBookName("나목");
		bookArray1[0].setAuthor("박완서");
		//얕은 복사(내용이 복사된것이 아니라 주소값만 복사)
		
		System.out.println("================");
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
		}
		//bookArray1을 수정했는데 같은 주소값을 공유하고 있는 bookArray2도 같이 수정됨
		
		System.out.println("=====================");
		
		bookArray2[0] = new Book();
		bookArray2[1] = new Book();
		bookArray2[2] = new Book();
		//주소를 새롭게 할당
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray2[i].setAuthor(bookArray1[i].getAuthor());
			bookArray2[i].setBookName(bookArray1[i].getBookName());
		}
		//주소값이 아닌 내용만 가져와서 복사
		
		for(int i=0; i<bookArray2.length; i++) {
			bookArray1[i].showBookInfo();
			bookArray2[i].showBookInfo();
			System.out.println("bookArray1["+i+"]   :  "+bookArray1[i]);
			System.out.println("bookArray2["+i+"]   :  "+bookArray2[i]);
		}
		//내용은 같지만 다른 주소값을 가짐
		
		String[] strArr = {"Java", "Android", "C"};
		
		for(String s : strArr) {
			System.out.println(s);
		}
		//향상된 for 문(enhanced for loop)
		//배열 요소의 처음부터 끝까지 모든 요소를 참조 할대 편리한 반복문
	}
	
}
