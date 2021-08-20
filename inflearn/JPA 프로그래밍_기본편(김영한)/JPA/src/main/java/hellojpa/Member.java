package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //JPA를 사용하는 얘라고 인식
//@Table(name = "USER") //USER라는 테이블에 조작이 됨
public class Member {

    @Id //PK값은 알려줘야함
    private Long id;
    //@Column(name = "username") SQL 조작시 name이 아니라 username으로 동작함
    private String name;

    public Member(){
    }

    public Member(Long id, String name){
        this.id = id;
        this.name = name;
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
