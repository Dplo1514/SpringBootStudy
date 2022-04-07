package plo.core.order;

import org.junit.jupiter.api.Test;
import plo.core.Order.Order;
import plo.core.Order.OrderService;
import plo.core.Order.OrderServiceImpl;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(memberRepository);
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createMember(){
        long memberId = 1L;
        Member member = new Member(memberId, "spring", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
