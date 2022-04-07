package plo.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import plo.core.member.Grade;
import plo.core.member.Member;
import plo.core.member.MemberService;
import plo.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //appconfig에서 추상체를 할당받으면 appconfig에서 할당됐던 구현체도 리턴된다.
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //spring container의 선언
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //선언된 spirng container에서 bean을 꺼내온다. (bean이 등록된 method명 , 반환타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("findmember = " + findmember.getName());
    }
}
