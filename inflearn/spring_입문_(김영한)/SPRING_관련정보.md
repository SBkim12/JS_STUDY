일반적인 웹 애플리케이션 계층 구조
	컨트롤러 : 웹 MVC의 컨트롤러 역할
	서비스 : 핵심 비즈니스 로직 구현
	리포지토리 : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
	도메인 : 비즈니스 도메인 객체, ex) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨

클래스 의존관계
	아직 데이터 저장소가 선정되지 않았을 경우, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계

테스트 케이스 작성
	JUnit이라는 프레임워크로 테스트를 실행해서 여러 테스트를 시간을 소모를 줄여서 할 수 있다.

컴포넌트 스캔과 자동 의존관계 설정
	- @Component - 스프링 빈으로 자동 등록
	-  @Controller, @Service, @Repository - 컴포넌트 스캔과 같은 맥락(스프링 빈을 자동 등록)
	- main이 있는 패키지의 하위를 컴포넌트 스캔을 하여서 빈을 등록함(다른 패키지/상위 패키지 인 경우 빈 등록이 되지 않음 - 필요한 경우 설정 필요)
	- 싱글톤으로 등록(유일하게 하나만 등록해서 공유, 같은 스프링 빈이면 모두 같은 인스턴스이다.)
	- 정형화된 컨트롤러, 서비스 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다. 정형화 되지 않거나 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
	- @Autowired를 통한 DI는 스프링이 관리하는 객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.

DI(의존성 주입) 방법 3가지

- 생성자 주입(이걸 쓰는게 좋다! - 의존관계가 실행중에 동적으로 변하는 경우가 거의 없기 때문)
@Controller
public class MemberController {
	private final MemberService memberService;
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}

- 필드 주입
@Controller
public class MemberController {
	@Autowired private final MemberService memberService;
}

- setter 주입
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public setMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}

스프링 컨테이너
	- 개방-폐쇄 원칙(OCP, Open-Closed Principle)
		 - 확장에는 열려있고, 수정, 변경에는 닫혀있다
	- DI(Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.

스프링 테스트 관련 어노테이션
	- @SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.
	- @Transactional : 테스트 케이스에 이 어노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다.(DB에 데이터가 남지 않아 다음 테스트에 영향을 주지 않는다.)

JPA
	- 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행
	- SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환 가능
	- 개발 생산성을 크게 높일 수 있음
	- ORM(Object와 Relational Database의 테이블을 mapping 해준다)

스프링 데이터 JPA
	- 리포지토리에 구현 클래스 없이인터페이스 만으로 개발 완료 가능
	- CRUD 기능도 스프링 데이터 JPA가 모두 제공
	- 단순 반복 개발 코드 단축 가능 (=> 핵심 비즈니스 로직 개발 집중 가능)
	- 제공 기능
		- 인터페이스를 통한 기본적인 CRUD
		- findByName() , findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공
		- 페이징 기능 자동 제공
	-  복잡한 동적 쿼리는 Querydsl이라는 라이브러리를 사용(쿼리도 자바 코드로 안전하게 작성할 수 있고, 동적
쿼리도 편리하게 작성할 수 있다)
	- 위의 것으로 해결하기 어려울 경우 JPA가 제공하는 네이티브 쿼리 or 스프링 JdbcTemplate을 사용하면 된다.

AOP(Aspect Oriented Programming, 관점 지향 프로그래밍)
	- 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리
	- 핵심 관리 사항 깔끔하게 유지 가능, 코드 수정이 용이함
	- 비지니스 메소드로 진행하도록(proceed) 하는 메소드가 proceed() 메소드
	- proceed 반환 값 : Obejct(비지니스 메소드가 실행한 후의 결과 값)
	- 동작 시점(동작 방식)
		- before : 비지니스 메소드 실행 전에 Advice 메소드 실행
		- after-returning : 비지니스 메소드가 성공적으로 리턴되면 Advice 메소드 동작. 즉 비지니스 메소드가 성공적으로 실행되었을 경우에만 Advice 메소드 동작
		- after-throwing: 비지니스 메소드 실행중 예외가 발생할 경우 Advice 메소드 실행. 즉 비지니스 메소드가 실행에 실패했을 경우에만 Advice 메소드 실행	
		- after : 비지니스 메소드의 성공 실패와 상관없이 비지니스 메소드 실행 후 무조건 Advice 메소드 동작
		- around : 비지니스 메소드 실행 전과 실행 후 Advice 메소드 동작하는 형태

출처: https://developer-joe.tistory.com/221 [코드 조각-Android, Java, Spring, JavaScript, C#, C, C++, PHP, HTML, CSS, Delphi]
이클립스 단축기
	Rename(변수명) = 변경할 변수명 더블클릭으로 하이라이트 후 Alt + Shift + R 
	Extract Method = Alt + Shift + M
	quick search = Ctrl + Alt + Shift + L (or Ctrl + Shift + L)
	자동 정렬 = Ctrl + Shift + F