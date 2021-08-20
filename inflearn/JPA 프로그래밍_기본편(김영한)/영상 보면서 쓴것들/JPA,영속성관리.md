JPA에서 가장 중요한 2가지

	- 객체와 관계형 데이터베이스 매핑(Object Relational Mapping)
	- 영속성 컨텍스트
		- JPA를 이해하는 가장 주용한 용어
		- '엔티티를 영구 저장하는 환경'
		- EntityManager.persist(entity);
		- 엔티티 매니저를 통해서 영속성 컨텍스트에 접근
		- 엔티티의 생명주기
			- 비영속(new/transiend) - 객체만 생성한 상태
			- 영속(managed) - 생성한 객체를 저장한 상태 ex) em.persist(member);
			- 준영속(detached) - 회원 엔티티를 영속성 컨텍스트에서 분리 ex) em.detach(member)
			- 삭제(removed) - 객체를 삭제한 상태 ex) em.remove(member);
		- 영속성 컨텍스트의 이점
			- 1차 캐시(
			- 동일성(identity) 보장
			- 트랜잭션을 지원하는 쓰기 지연(transactional write-behind)
			- 변경 감지(Dirty Chcking)
			- 지연 로딩(Lazy Loading)


플러시
	- 영속성 컨텍스트의 변경내용을 데이터베이스에 반영
	- 영속성 컨텍스트를 비우지 않음
	- 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
	- 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화하면 됨

플러시 발생
	- 변경 감지
	- 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
	- 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 쿼리)

영속성 컨텍스트를 플러시하는 방법
	- em.flush() _ 직접호출
	- 트랜잭션 커밋 _ 플러시 자동 호출
	- JPQL 쿼리 실행 _ 플러시 자동 호출

플러시 모드 옵션
	-  FlushModeType.AUTO _ 커밋이나 쿼리를 실행할 때 플러시 (기본값)
	- FlushModeType.COMMIT _ 커밋할 때만 플러시


준영속 상태
	- 영속(em.persist or 조회) -> 준영속
	- 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
	- 영속성 컨텍스트의 기능 사용 못함

준영속 상태 만드는 방법
	- em.detach(entity) _ 특정 엔티티만 준영속 상태로 전환
	- em.clear(); _ 영속성 컨텍스트를 완전히 초기화
	- em.close(); _ 영속성 컨텍스트 종료

	