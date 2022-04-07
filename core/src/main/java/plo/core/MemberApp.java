package plo.core;

import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //appconfig에서 추상체를 할당받으면 appconfig에서 할당됐던 구현체도 리턴된다.
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("findmember = " + findmember.getName());
    }
}
