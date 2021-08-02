package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
	
	//JPA에서 공통 쿼리에 포함되지 않는 내용을 형식에 맞춰 적으면 알아서 쿼리를 작성해줌
	//JPQL select m from Member m where m.name = ?
	@Override
	Optional<Member> findByName(String name);
	
	//ex) Optional<Member> findByNameAandId(String name, Long id);
	
}
//스프링 데이터 JPA가 SpringDataJpaMemberRepository 를 스프링 빈으로 자동 등록해준다.
//data.jpa.repository.JpaRepository에 단순 조회 쿼리들이 있어 직접 만들지 않고 바로 사용이 가능하다