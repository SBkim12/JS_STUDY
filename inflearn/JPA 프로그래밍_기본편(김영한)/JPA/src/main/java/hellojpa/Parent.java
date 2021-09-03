package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //영속성 전이: CASECADE //고아객체 제거 : 부모엔티티와 연관관계가 끝어진 자식 엔티티를 자동으로 삭제(OrphanRemoval= true)
    //CascadeType종류 : ALL, PERSIST, REMOVE
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true) // 영속성 전이 + 고아객체,생명주기 => 부모 엔티티를 통해서 자식의 생명주기를 관리할수 있음, DDD(도메인 주도 설계)의 Aggregate Root개념을 구현시 유용
    private List<Child> childList = new ArrayList<>();
    // 영속성 전이는 연관 관계를 매핑하는 것과 아무 관련이 없음
    // 엔티티를 영속화할 때 연관된 엔티티도 함께 영속화하는 편리함을 제공할 뿐

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

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

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}

