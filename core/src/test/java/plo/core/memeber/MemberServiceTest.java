package plo.core.memeber;

import org.junit.jupiter.api.Test;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(memberRepository);

    @Test
    void join(){
        //given
        Member member = new Member(1L , "spring" , Grade.VIP);
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(member1);
    }
}
