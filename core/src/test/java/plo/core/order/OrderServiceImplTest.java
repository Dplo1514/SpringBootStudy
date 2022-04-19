package plo.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import plo.core.Order.Order;
import plo.core.Order.OrderServiceImpl;
import plo.core.discount.FixDiscountPolicy;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L  , "hyuk" , Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
         assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}