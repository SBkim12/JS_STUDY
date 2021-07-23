캡슐은 서로를 사용하거나 사용되는 관계

Has A (상속) -  캡슐이 다른 캡슐의 객체를 가지고 있는 상태(부품으로 갖는 상황)
Compossition Has A - 한번에 모든 부품을 갖는 상태로 만든 것
Aggregation Has A - 필요할 때마다 부품을 추가하며 만드는 것

Has A 정의
has-a는 구성 관계를 의미하며 한 오브젝트(구성된 객체, 또는 부분/멤버 객체라고도 부릅니다)가 다른 오브젝트(composite type이라고 부릅니다)에 "속한다(belongs to)"를 말합니다. 단순히 말해, has-a 관계는 객체의 멤버 필드라고 불리는 객체를 말하며, Multiple has-a 관계는 소유 계층구조를 형성하기 위해 결합하는 경우를 말합니다.

EX) C++
class A
{
public:
    void DoSomething()
    {
        b.Doing();
private:
    B b;
};

class B
{
public:
    void Doing()
    {
        // Do something in B class
        ...
    }
};
=> A의 멤버 필드로 B를 가지고 있고, 이를, A의 기능 구현에 사용하고 있다는 점