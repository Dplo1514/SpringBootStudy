package plo.core.discount;

import plo.core.member.Grade;
import plo.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int DiscountFixAmount = 1000; //1000원 할인하겠다.

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return DiscountFixAmount;
        }else {
            return 0;
        }
    }
}
