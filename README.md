# springboot 복습 : 간단한 web app

** 간단한 회원등록 및 조회 web app

1) 개발환경
- IntelliJ(Terminal → cd 프로젝트 폴더 → ./gradlew bootRun)
- Spring Boot 2.6.3
- java 11
- MyBatis or Spring Data JPA
- mysql 8
- gradle
- view template engine >> thymeleaf(.html)

2) 프로젝트 구조
```
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── springboot
    │   │               ├── SpringbootApplication.java(C)
    │   │               ├── controller
    │   │               │   ├── MemberApiController(C)
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   └── 
    │   │               ├── service
    │   │               │   ├── MemberService(C)
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   └── 
    │   │               ├── repository
    │   │               │   ├── MemberRepository(I)
    │   │               │   ├── MemoryMemberRepository(C)
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   └── 
    │   │               ├── domain
    │   │               │   ├── Member(C)
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   ├── 
    │   │               │   └── 
    │   │               └── dto
    │   │                   ├── request
    │   │                   │       ├── RequestMemberDto(C)
    │   │                   │       ├── 
    │   │                   │       └── 
    │   │                   └── response
    │   │                           ├── ResponseMemberDto(C)
    │   │                           ├── 
    │   │                           └── 
    │   │               
    │   └── resources
    │       └── application.yaml
```


3) 비즈니스 요구사항 정리
- 데이터: 회원ID, 이름
- 기능: 회원 등록, 조회
- 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)
- 구조
  - controller : RestController(Rest API) -> MemberApiController
  - service : Business Logic -> MemberService
  - repository : JPA or MyBatis ->  MemberRepository(interface)
    - 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계 
    - 데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정 
    - 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용
  - domain : Member
  - dto : requestMemberDto, responseMemberDto
