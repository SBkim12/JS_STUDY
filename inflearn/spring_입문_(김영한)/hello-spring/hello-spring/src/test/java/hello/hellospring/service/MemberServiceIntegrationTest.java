package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest
@Transactional // 프로그램이 끝날 때 DB의 데이터를 프로그램 시작 전 상태로 ROLLBACK 한다
public class MemberServiceIntegrationTest {
	
	//테스트시 그냥 간단하게 사용하기 위해 바로 @Autowired
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	//@Commit //데이터 롤백하지 않고 저장
	void 회원가입() {
		
		//given
		Member member = new Member();
		member.setName("spring100");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		/*
		try {
			memberService.join(member2);
			fail();
		}catch(IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		*/
		
		
		//then
	}
	
}
