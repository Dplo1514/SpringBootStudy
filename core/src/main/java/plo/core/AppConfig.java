package plo.core;

import plo.core.Order.OrderService;
import plo.core.Order.OrderServiceImpl;
import plo.core.discount.FixDiscountPolicy;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;
import plo.core.member.MemoryMemberRepository;

//Appconfig은 애플리케이션에 실제로 필요한 구현객체를 생성한다.
//생성한 객체 인스턴스 참조를 생성자를 통해서 연결해준다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
