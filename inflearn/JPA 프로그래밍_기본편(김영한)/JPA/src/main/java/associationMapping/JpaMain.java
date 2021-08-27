package associationMapping;


import hellojpa.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        //엔티티 매니터 팩토리는 하나만 생성해서 앱전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); /* 변수 자동 생성 단축키 Alt+Ctrl+V */

        //엔티티 매니저는 쓰레드간에 공유X(사용 후 버려야함)
        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다!
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //키 매핑 테스트
        //객체의 양방향 관계는 사실 서로다른 단방향 관계 2개이다.
        /*
        try{

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Members member = new Members();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Members findMember = em.find(Members.class, member.getId());
            List<Members> members = findMember.getTeam().getMembers(); //양방향 연관관계

            for(Members m : members){
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
         */
    try{
        Members member = new Members();
        member.setUsername("member1");

        em.persist(member);

        Team team = new Team();
        team.setName("teamA");
        //
        team.getMembers().add(member);

        em.persist(team);

        tx.commit();
    }catch(Exception e){
        tx.rollback();
    }finally{
        em.close();
    }

       emf.close();
    }
}

//양방향 매핑시 가장 많이 하는 실수

//역방향 (주인이 아닌 방향)만 연관관계 설정
//team.getMembers().add(member);
//순수한 객체 관계를 고려하면 항상 양쪽 다 값을 입력해야한다.
//연관관계 편의 메소드를 생성하자 (두개의 함수 묶기)
//양방향 매핑시에 무한 루프를 조심하자 ex) toString(), lombok, JSON 생성 라이브러리

//양방향 매핑 정리
//단방향 매핑만으로도 이미 연관관계 매핑 완료
//양방향 매핑은 반대 방향 조회가 기능이 추가된 것 뿐
//JPQL에서 역방향으로 탐색할 일이 많음
//단방향 매핑을 잘 하고 양방향은 필요할 때 추가해도 됨(테이블 영향 X)
//연관관계 주인은 외래키의 위치를 기준으로 정하면됨!