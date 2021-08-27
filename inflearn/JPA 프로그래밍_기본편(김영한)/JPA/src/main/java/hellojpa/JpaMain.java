package hellojpa;


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

        // 입력
        /*
        try{
            //비영속
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 101L); //1차 캐시에서 조회

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());


            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        */

        // 검색
        /*
        try{
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
         */


        //JPQL - 엔티티 객체를 중심으로 개발, 검색할 때도 엔티티 객체를 대상으로 검색, 엔티티 객체를 대상으로 하는 SQL이 필요
        //jPQL은 엔티티 객체를 대상으로 쿼리(객체 지향 SQL)
        //SQL은 데이터베이스 테이블을 대상으로 쿼리
        /*
        try{
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) // 1번부터
                    .setMaxResults(8) // 8번까지
                    .getResultList();

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        */


        //트랜잭션을 지원하는 쓰기 지원
        /*
        try{
            Member member1 = new Member( 150L, "A");
            Member member2 = new Member( 160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("========================");

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
         */

        //엔티티 수정(변경 감지)
        //flush()-영속성 컨텍스트의 변경내용을 데이터베이스에 반영 -> 엔티티와 스냅샷 비교 -> UPDATE SQL 생성 -> flush -> commit
        /*
        try{
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZ");

            //JPA는 값을 바꾸면 트랜잭션이 커밋되는 시점에 변경을 반영한다.

            System.out.println("========================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
         */

        //삭제
        /*
        try{
            Member findMember = em.find(Member.class, 1L);

            em.remove(findMember);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        */

        //flush
        /*
        try{
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); // 데이터베이스에 인서트쿼리가 이시점에 즉시 실행됨

            System.out.println("========================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
         */

        //준영속
        /*try{
            Member member = em.find(Member.class, 150L);
            member.setUsername("AAAAA");

            //em.detach(member); //특정 엔티티 준영속상태로 변경
            em.clear(); //영속성 컨텍스트를 완전히 초기화

            Member member2 = em.find(Member.class, 150L); // 1차캐시에 조회된 내용이 없어졌기 때문에 다시 조회쿼리 동작

            System.out.println("========================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }*/

        //키 매핑 테스트
        try{
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("=================");

            em.persist(member1); //1,51
            em.persist(member2); //MEMORY
            em.persist(member3); //MEMORY


            System.out.println("member1.id = " + member1.getId());
            System.out.println("member2.id = " + member2.getId());
            System.out.println("member3.id = " + member3.getId());

            System.out.println("=================");

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

       emf.close();
    }
}
