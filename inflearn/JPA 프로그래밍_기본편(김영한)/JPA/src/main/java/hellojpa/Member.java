package hellojpa;

import javax.persistence.*;
import java.util.Date;


//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = “MEMBER_SEQ", allocationSize = 1) //시퀀스 테이블이 DB에 생성됨
//@Table(name = "USER") //USER라는 테이블에 조작이 됨, 속성 - name, catalog, schema, uniqueConstraints(DDL)
@Entity //(name = "Member") //JPA를 사용하는 얘라고 인식
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR1",
        sequenceName = "MEMBER_SEQ1",
        initialValue = 1, allocationSize = 50)  //직접 Sequence 생성, 50개를 DB에서 한번에 받아오겠다.
public class Member {

    //@GeneratedValue(strategy = GenerationType.SEQUENCE) //데이터베이스 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트(예: 오라클 시퀀스)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR") // 위에서 생성한 TableSequence 사용
    @Id // 기본 키 매핑 (직접할당)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR1") // 위에서 직접 생성한 Sequence 사용
    private Long id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성을 데이터베이스에 위임
//    private Long id;

    //@Column(unique = tue, length = 10); DDL 생성에만 영향을 줌(JPA의 실행 로직에 영향 X)
    @Column(name = "name") //칼럼 매핑
    private String username;
    /*
    * name - 필드와 매핑할 테이블을 컬럼 이름
    * insertable , updatable - 등록, 변경 가능 여부
    * nullable(DDL) - null값의 허용 여부를 설정한다. false로 설정함녀 DDL 생성 시에 not null 제약 조건이 붙는다.
    * unique(DDL) - @Table의 uniqueConstraints와 같지만 한 컬럼에 간단히 유니크 제약조건을 걸 때 사용한다.
    * columnDefinition(DDL) - 데이터베이스 컬럼 정보를 직접 줄 수 있다.
    * length(DDL) - 문자 길이 제약조건, String 타입 에섬나 사용한다.
    * precision, scale(DDL) - BigDecimal 타입에서 사용(BigInteger도 가능), 정밀한 소수를 다루어야 할 때만 사용
    * */

    public Member(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   /*
    private Integer age;

    @Enumerated(EnumType.STRING) // enum 타입 매핑
    private RoleType  roleType;
    // EnumType.ORDINAL이 default 값인데 사용하면 X
    // enum의 순서로 데이터가 저장되는데 enum데이터 추가 및 수정하여 저장시 DB가 꼬일 수 있음

    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입 매핑
    private Date createdDate;
    //java.util.Date, java.util.Calendar을 매핑할 때 사용
    // LocalDate, LocalDateTime을 사용할 때는 생략 가능(최신 하이버네이트 지원)

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // BLOB(나머지), CLOB(문자) 매핑, 속성이 없다.
    private String description;

    @Transient //주로 메모리상에서만 임시로 어떤 값을 보관하고 싶을 때 사용, 필드 매핑X, 데이터베이스에 조회and저장 X
    private int temp;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

 */
}
