package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

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

        //키 매핑 테스트
        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);


            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
