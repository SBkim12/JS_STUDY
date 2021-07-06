Git 협업 시 고려사항

Branch Workflows
Branch Protection Rule
Code Review Rule
Branch Naming Convention
Commit Message Convention
CI/CD
Test Automation



Branch Workflows

 - 신규 기능개발, 버그, 수정, 배포 등을 위한 사용 규칙
 - Branch Workflows에 따라 Branch Protection Rule, Code Review Rule이 결정

 - 대표적인 Branch WorkFlows
	- Forking Workflow
		- 오픈소스 프로젝트에서 주로 사용하는 방법
		- 각 개발자가 중앙 원격 저장소를 forking한 본인의 저장소에서 개발을 진행하는 방법
		- 장점 : 중앙 원격 저장소를 안전하게 보호하기 좋은 방법
		- 단점 : 저장소가 여러개로 분리되어 구조가 복잡하며, 개발자간 코드 리뷰 및 모니터링이 불편함
 	- Feature Branch Workflow
		- 소규모의 조직에서 사용하기 좋은 방법
		- 하나의 주앙 원격 저종사를 개발자들이 공유하며 각 요건은 분리된 feature branch에서 개발진행
		- 장점 : branch 생성과 삭제가 유연하여 소규모 조직이나 개발 초기에 사용하기 유리
		- 배포버전 관리의 어려움, branch 생성 기준의 모호함
	- Gitflow Workflow  *상세 설명 페이지 : https://gmlwjd9405.github.io/2018/05/11/types-of-git-branch.html
		- 대규모 프로젝트나 실제 운영 중인 서비스에 적용하기 좋은 엄격한 작업방식
		- 두개의 main branch와 여러가지 Sub Branch가 존재
		- Branch 종류
			- Master : prod 배포를 위한 branch, 항상 배포 가능한 상태로 유지
			- Develop : 다음 출시 버전을 개발하는 브랜치
			- Feature : 기능을 개발하는 브랜치
			- Realease : 이번 출시 버전을 준비하는 브랜치
			- Hofix : 출시 버전에서 발생한 버그를 수정 하는 브랜치
		- 장점 : 배포 버전의 체계적인 관리가 용이, 배포 전략에 따라 다양하게 변형이 가능
		- 단점 : 충돌 발생 가능성이 많음, 테스트를 위한 서버가 다수 필용할 수 있음
		
	- Trunk Based Development
		- 모든 개발자가 Master Branch 하나에서 작업을 진행
		- Pair Programming을 기반으로 이루어짐
		- 작은 단위로 개발이 이루어짐
		- 신뢰할 수 있는 자동화 테스트가 중요
		- 개발과 동시에 코드리뷰가 이루어지므로 진정한 의미의 협업이라 할 수 있음
		- 팀 전원의 개발 역량이 모두 중요
		- Feature Branch를 사용하는 방식이 각 개발자의 개별 능력을 최적화하는 반면에 Trunk Based Development는 팀의 능력을 최적화함

git 버전관리란?
	시맨틱 버저닝