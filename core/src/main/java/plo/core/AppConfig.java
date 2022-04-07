package plo.core;

import plo.core.Order.OrderService;
import plo.core.Order.OrderServiceImpl;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;
import plo.core.member.MemoryMemberRepository;

public class AppConfig {

    //추상체를가 구현체를 리턴하도록 함으로써
    //
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new );
    }


}
