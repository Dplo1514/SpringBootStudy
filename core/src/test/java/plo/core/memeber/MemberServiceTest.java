package plo.core.memeber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import plo.core.AppConfig;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
