package plo.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import plo.core.Order.Order;
import plo.core.Order.OrderService;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "spring", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "test", 20000);

        System.out.println("order = " + order);
        System.out.println("order.caculatePrice() = " + order.caculatePrice());
    }
}
