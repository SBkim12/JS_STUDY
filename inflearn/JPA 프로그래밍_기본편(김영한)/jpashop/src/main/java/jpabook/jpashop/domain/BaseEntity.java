package jpabook.jpashop.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 공통적인 속성을 합쳐서 관리
@MappedSuperclass
public class BaseEntity {

    //@Column(name = "INSERT_MEMBER")
    private String createdBy;
    private LocalDateTime createDate;
    //@Column(name = "UPDATE_MEMBER")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}


//@MappedSuperclass
//상속관계 매핑X
//엔티티X, 테이블과 매핑X
// 부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
// 조회, 검색 불가(em.find(BaseEntity) 불가)
// 직접 생성해서 사용할 일 없으므로 추상 클래스 권장
// 테이블과 관계 없고, 단순히 엔티티가 공통으로 사용하는 매핑 정보를 모으는 역할
// 주로 등록일, 수정일, 등록자, 수정자 같은 전체 엔티티에서 공통으로 적용하는 정보를 모을 때 사용
// PS) @Entity 클래스는엔티티나 @MappedSuperclass로 지정한 클래스만 상속 가능
