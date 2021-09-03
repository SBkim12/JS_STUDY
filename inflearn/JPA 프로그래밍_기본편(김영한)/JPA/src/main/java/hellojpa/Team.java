package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;


    //양방향 매핑 규칙
    //객체의 두 관계중 하나를 연관관계의 주인으로 지정
    //연관관계의 주임나이 외래키를 관리(등록, 수정)
    //주인 아닌 쪽은 읽기만 가능
    //주인은 mappedBy 속성 사용 X
    //주인이 아니면 mappedBy 속성으로 주인 지정
    @OneToMany //(mappedBy = "team") mappedby - 양방향 매핑에서 주인이 아닌 것으로 주인지정(왜래키가 잇는 곳을 주인으로 정해라) - 다대일 양방향
    @JoinColumn(name = "TEAM_ID") // 일대다 단방향, 객체와 테이블의 차이 때문에 반대편 테이블의 외래키를 관리하는 특이한 구조
    private List<Member> member = new ArrayList<Member>();

    public List<Member> getMembers() {
        return member;
    }

    public void setMembers(List<Member> members) {
        this.member = members;
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
}

