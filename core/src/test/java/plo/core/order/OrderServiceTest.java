package plo.core.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import plo.core.AppConfig;
import plo.core.Order.Order;
import plo.core.Order.OrderService;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
//        orderService = appConfig.orderService();
    }

    @Test
    void createMember(){
        long memberId = 1L;
        Member member = new Member(memberId, "spring", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


//    @Test
//    void filedInjectionTest(){
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1, "iemt1" , 10000);
//    }

}
