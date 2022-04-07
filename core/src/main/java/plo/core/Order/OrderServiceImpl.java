package plo.core.Order;

import plo.core.discount.DiscountPolicy;
import plo.core.discount.RateDiscountPolicy;
import plo.core.member.Member;
import plo.core.member.MemberRepository;
import plo.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    /*
        클라이언트인 OrderServiceImpl은 추상클래스(interface)인 DiscountPolicy뿐만 아니라
        구체 클래스인 FixDiscountPolicy에도 의존하고있다.
        이는 Dip를 위반하고 있음을 뜻한다.
        또한 새로운 구체클래스 RateDiscountPolicy로 기능을 변경할 때
        구체 OrderServiceImpl에서의 코드 변경이 일어난다.
        이는 OCP를 위반하고있음을 뜻한다.
        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
        private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    */

    /*
    위의 문제점을 해결하고자 Client인 OrderServiceImpl은 interface에만 의존하도록 아래처럼 의존관계를 변경해줬다.
    허나 구현체가 없기 때문에 정상적으로 동작할 수 없다.
    누군가가 구현체를 클라이언트에 대신 주입해줘야한다
    */

    /*
    Appconfig이 외부에서 주입할 구현객체를 할당해줌으로써
    OrderServiceImpl은 인터페이스에만 의존한다.
    */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member memeber = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(memeber, itemPrice);

        return new Order(memberId , itemName , itemPrice , discountPrice);
    }
}
