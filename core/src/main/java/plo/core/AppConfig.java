package plo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plo.core.Order.OrderService;
import plo.core.Order.OrderServiceImpl;
import plo.core.discount.DiscountPolicy;
import plo.core.discount.RateDiscountPolicy;
import plo.core.member.MemberRepository;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;
import plo.core.member.MemoryMemberRepository;

//Appconfig은 애플리케이션에 실제로 필요한 구현객체를 생성한다.
//생성한 객체 인스턴스 참조를 생성자를 통해서 연결해준다.
@Configuration
public class AppConfig {

    @Bean //spirng container에 등록된다.
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
