package plo.core;

import plo.core.Order.Order;
import plo.core.Order.OrderService;
import plo.core.Order.OrderServiceImpl;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "spring", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "test", 10000);

        System.out.println("order = " + order);
        System.out.println("order.caculatePrice() = " + order.caculatePrice());
    }
}
