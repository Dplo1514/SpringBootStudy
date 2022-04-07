package plo.core.discount;


import plo.core.member.Member;

public interface DiscountPolicy {

    /**
     * @retunrn 할인 대상 금액
     */
    int discount(Member member , int price);
}
