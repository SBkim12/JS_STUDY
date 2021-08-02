package hello.hellospring.repository;


//import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {
	
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach //메서드 실행이 끝날때마다 실행됨(콜백)
	public void afterEach() {
		repository.clearStore();
	}
	// 테스트 메서드가 하나 돌때마다 데이터를 클리어 시켜줌
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		//Assertions.assertEquals(result, member); //junit.jupiter 값 일치 확인
		
		//Assertions.assertThat(member).isEqualTo(result); //assertj.core 값 일치 확인
		assertThat(member).isEqualTo(result); //static으로 임포트해서 바로 사용 하기
		
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository. save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository. save(member2);
		
		Member result = repository.findByName("spring1").get();
		
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);
	}
}
