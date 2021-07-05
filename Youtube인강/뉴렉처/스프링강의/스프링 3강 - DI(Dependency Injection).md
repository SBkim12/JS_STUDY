스프링 프레임워크 3강

DI(Dependency Injection) - 의존성(종속성, 부품) 주입

Composition has a - 일체형
A가 B(dependency, 부품)를 일체형으로 가졌다
class A
{
    private B b;
    
    public A() {
        b = new B(); //직접 생성
    }
}

Association has a - 조립형
A가 B(dependency, 부품)를 조립형으로 가졌다
class A
{
    private B b;
    
    //외부에서 가져와서 사용
    public void setB(B b){
        this.b = b;
    }
}

=> 코드의 수정이 유연해야 함으로 결합력이 낮은 조립형을 사용하는것이 좋음


조립형으로 DI하는 구조 2가지

1.  Setter Injection
    B b = new B(); -> dependency
    A a = new A();
    a.setB(b); -> injection

2.  Construction Injection
    B b = new B(); -> dependency
    A a = new A(b); -> injection


스프링은 DI의 역할을 대신 해준다(우리는 가져다 쓰기만하면 된다)