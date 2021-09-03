package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name ="USERNAME")
    private String username;

//    @Column(name ="TEAM_ID")
//    private Long teamid;

    //외래키 매핑  N:1 관계
    @ManyToOne(fetch = FetchType.LAZY) //즉시로딩 - EAGER  , 지연로딩 - LAZY 사용
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    public Team getTeam() {
        return team;
    }

    //연관 관계 편의 메소드
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    //기간 Period
    @Embedded
    private Period workdPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city",column=@Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",column=@Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",column=@Column(name = "WORK_ZIPCODE"))
    })
    private Address workdAddress;


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

    public Team getTeams() {
        return team;
    }

    public void setTeams(Team team) {
        this.team = team;
    }

    public Locker getLockers() {
        return locker;
    }

    public void setLockers(Locker lockers) {
        this.locker = lockers;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Period getWorkdPeriod() {
        return workdPeriod;
    }

    public void setWorkdPeriod(Period workdPeriod) {
        this.workdPeriod = workdPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}