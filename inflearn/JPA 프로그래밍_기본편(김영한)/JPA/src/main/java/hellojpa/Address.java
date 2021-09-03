package hellojpa;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    // equals() 메소드를 적절하게 재정의(주로 모든 필드 사용)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}
//객체 타입은 참조 값을 직접 대입한는 것을 막을 방법이 없다.
//객체의 공유 참조는 피할 수 없다.
//객체 타입을 수정할 수 없게 만들면 부작용을 원천 차단(객체 타입은 참조를 전달하기 때문)
//값 타입은 불변 객체(immutable object)로 설계해야함
//불변 객체 : 생성 시점 이후 절대 값을 변경할 수 없는 객체
