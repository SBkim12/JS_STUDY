package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        //엔티티 매니터 팩토리는 하나만 생성해서 앱전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); /* 변수 자동 생성 단축키 Alt+Ctrl+V */

        //엔티티 매니저는 쓰레드간에 공유X(사용 후 버려야함)
        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다!
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 상관관계 매핑
    /*
    try{

        Movie movie = new Movie();
        movie.setDirector("aaaa");
        movie.setActor("bbbb");
        movie.setName("바람과함께사라지다");
        movie.setPrice(10000);

        em.persist(movie);

        em.flush();
        em.clear();

        Item item = em.find(Item.class, movie.getId());
        System.out.println("item = " + item);
        // 구현클래스마다 테이블 전략사용시 union 을 사용해 모든 테이블을 다 찾아봐야하는 상황이 생길수 있음

        tx.commit( );
    }catch(Exception e){
        tx.rollback();
    }finally{
        em.close();
    }
    */

        //Mapped Superclass - 매핑정보 상속
        /*
        try{

            Memberss member = new Memberss();
            member.setUsername("user1");
            member.setCreateDate(LocalDateTime.now());
            member.setCreatedBy("Kim");

            em.persist(member);

            em.flush();
            em.clear();

            tx.commit( );
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        */

        //프록시
        /*
        try{
            
            Memberss member1 = new Memberss();
            member1.setUsername("member1");
            em.persist(member1);

            Memberss member2 = new Memberss();
            member2.setUsername("member2");
            em.persist(member2);

            em.flush();
            em.clear();

            Memberss m1 = em.find(Memberss.class, member1.getId());
//            Memberss m2 = em.find(Memberss.class, member2.getId());
            Memberss m2 = em.getReference(Memberss.class, member2.getId());

            Memberss reference = em.getReference(Memberss.class, member1.getId());
            System.out.println("reference = " + reference.getClass().getName()); // 프록시 클래스 확인 방법

            Hibernate.initialize(reference); //강제 초기화 (JPA 표준에는 초기화가 없어서 강제호출로 초기화)

            // 프록시 인스턴스의 초기화 여부 확인
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(reference ));


            logic(m1,m2);

            tx.commit();
        }finally{
            em.close();
        }

       emf.close();
    }
    private static void logic(Memberss m1, Memberss m2){
        System.out.println("m1 == m2: " + (m1 instanceof Memberss));
        System.out.println("m1 == m2: " + (m2 instanceof Memberss));
    }
         */

// 프록시 기초
// em.find : 데이터베이스를 통해서 실제 엔티티 객체 조횐
// em.getReference() : 데이터베이스 죄흘 미루는 가짜(프록시) 엔티티 객체 조회

//프록시 특징
// 실제 클래스를 상속받아서 만들어짐
// 실제 클래스와 겉 모양이 같다
// 사용하는 입장에서는 진짜 객체인지 프록시 객체인지 구분하지 않고 사용하면 됨(이론)
// 프록시 객체는 실제 객체의 참조(target)를 보관
// 프록시 객체를 호출하면 프록시 객체는 실제 객체의 메소드 호출
// 프록시 객체는 처음 사용할 때 한번만 초기화
// 프록시 객체가 실제 엔티티로 바뀌는 것은 아님, 초기화되면 프록시 객체를 통해서 실제 엔티티에 접근 가능
// * 프록시 객체는 원본 엔티티를 상속받음, 따라서 타입 체크시 주의해야함(==비교 실패, 대신 instance of 사용)
// * 영속성 컨텍스트에 찾는 엔티티가 있으면 em.getReference()를 호출해도 실제 엔티티 반환(반대일 경우 프록시 반환)
// 준영속 상태(영속성 컨텍스트의 도움을 받을수 없는)일때, 프록시를 초기화하면 문제 발생(org.hibernate.LazyInitializationException)

        //즉시,지연 로딩딩
        /*
       try{

           Teams teamA = new Teams();
           teamA.setName("teamA");
           em.persist(teamA);
           Teams teamB = new Teams();
           teamB.setName("teamB");
           em.persist(teamB);

            Memberss member1 = new Memberss();
            member1.setUsername("member1");
            member1.setTeams(teamA);
            em.persist(member1);

            Memberss member2 = new Memberss();
           member2.setUsername("member2");
           member2.setTeams(teamB);
            em.persist(member2);

            em.flush();
            em.clear();

            List<Memberss> members = em.createQuery ("Select m from Member m", Memberss.class).getResultList();
           //SQL : select * from Member;
           //SQL : select * from Team Where TEAM_ID= ???;

            Memberss m = em.find(Memberss.class, member1.getId());

            System.out.println("m = " + m.getTeam().getClass()); // 지연로딩으로 동작시 프록시를 가져옴

            System.out.println("=====================");
            System.out.println("teamName : " + m.getTeam().getName()); //지연로딩으로 동작시 실제 team을 사용하는 시점에 초기화(DB조회 쿼리 동작)
            System.out.println("=====================");

            tx.commit();
        }finally{
            em.close();
        }

         */
// 프록시와 즉시로딩 주의
// 가급적 지연 로딩만 사용(특히 실무에서)
// 즉시 로딩을 적용하면 예상하지 못한 SQL이 발생
// 즉시 로딩은 JPQL에서 N+1 문제를 일으킨다.
// @ManyToOne, @OneToOne은 기본이 즉시 로딩 -> LAZY로 설정
// @OneToMany, @ManyToMany는 기본이 지연 로딩

// 지연로딩 활용(이론)
// 같이 함께 자주쓰임 -> 즉시 로딩
// 같이 가끔 사용됨 -> 지연 로딩

// 지연로딩 활용(실무)
// 모든 연관 관계에서 지연로딩 사용할것
// 실무에서 즉시로딩 사용ㄴㄴ
// JPQL fetch 조인이나, 엔티티 그래프 기능 사용해라(뒤에나옴)
// 즉시로딩은 상상하지 못한 쿼리가 나간다.


//  CASCADE와 고아 객체
        /*try{
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }*/

        // 고아 객체 주의
        // 참조가 제거된 엔티티는 다른 곳에서 참조하지 않는 고아 객체로 보고 삭제하는 기능
        // 참조하는 곳이 하나일 때 사용해야함!!!
        // 특정 엔티티가 개인 소유할 때 사용
        //@OneToOne, @OneToMany만 가능
        // PS) 개념적으로 부모를 제거하면 자식은 고아가 된다. 따라서 고아  객체 제거기능을 활성화하면, 부모 제거시 자식도 함께 제거됨(CasecadeTpe.REMOVE처럼 동작)

    try{

        Address address = new Address("city", "street", "10");

        Member member = new Member();
        member.setUsername("hello");
        member.setHomeAddress(address);
        em.persist(member);

        //수정 방법 ( 통으로 바꾸기 )
        Address newAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
        member.setHomeAddress(newAddress);


        tx.commit();
    }catch(Exception e){
        tx.rollback();
        e.printStackTrace();
    }finally{
        em.close();
    }

        emf.close();
    }





}




