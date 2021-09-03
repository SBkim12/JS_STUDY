package hellojpa;

public class ValueMain {

    public static void main(String[] args){

        int a = 10;
        int b = a;

        b = 10;

        System.out.println("a == b  : " + (a==b));
        // 자바의 기본 타입은 절대 공유 X
        // Integer같은 래퍼 클래스나 String 같은 특수한 클래스는 공유 가능한 객체이지만 변경 X

        Address address1 = new Address("city", "street", "1000");
        Address address2 = new Address("city", "street", "1000");

        System.out.println("Address1 == Address2  : " + (address1 == address2) );
        System.out.println("Address1 equals Address2  : " + (address1.equals(address2)) );
    }

    //동일성(identify) 비교 : 인스턴스의 참조 값을 비교,== 사용
    //동등성(equivalence) 비교 :  인스턴스 값을 비교, equals() 사용
}
