package hellojpa;

import javax.persistence.*;

// JOIN 전략 선택
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // JOINED - 조인 전략, SINGLE_TABLE - 단일 테이블 전략, TABLE_PER_CLASS - 구현클래스마다 테이블 전략
//@DiscriminatorColumn //Dtype (단일 테이블 , 조인 시 사용)
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

// 조인 전략(정석)
/*
* 장점 : 테이블 정규화, 외래 키 참조 무결성 제약조건 활용 가능, 저장공간 효율화
* 단점 : 조회시 조인을 많이 사용(성능 저하), 조회 쿼리가 복잡, 데이터 저장시 INSERT SQL 2번 호출
* */
// 단일 테이블 전략(데이터 적고 확장 가능성 적을 경우 사용)
/*
* 장점 : 조인 필요없이 일반적으로 조회 성능이 빠름, 쿼리가 단순
* 단점 : 자식 엔티티가 매핑한 컬럼은 모두 null 허용, 단일 테이블에 모든것을 저장하므로 테이블이 커질수 있는 상황에 조회성능이 오히려 느려질 수 있다.
* */
// 구현 클래스마다 테이블 전략(비추천 전략-DB설계자와 ORM전문가 둘다 추천X)
/*
* 장점 : 서브 타입을 명확하게 구분해서 처리할 때 효과적, not null 제약 조건 사용 가능
* 단점 : 여러 자식 테이블을 함께 조회할때 성능이 느림(UNION SELECT), 자식들을 통합해서 쿼리하기 어려움
* */

// 관계형 데이터베이스는 상속 관계X
// 슈퍼타입 서브타입 관계라는 모델링 기법이 객체 상속과 유사
// 상속 관계 매핑 : 객체의 상속과 구조와 DB의 슈퍼타입 서브타입 관계를 매핑
