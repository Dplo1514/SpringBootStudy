package com.example.inflearn;

import com.example.inflearn.aop.TimeTraceAop;
import com.example.inflearn.repository.MemberRepository;
import com.example.inflearn.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//직접 스프링 등록하는 방법의 장점
//후에 MemoryMemberRepository를 dbMemberRepository로 구현체를 변경할 예정
//Spring config 파일에서만 return 구현체를 dbMemberRepository로 변경해주면
//다른 곳에서의 코드 변경이 일어날 일이 없다 //컴포넌트 스캔은 교체가 일어난다
    /*
    @Bean
    public MemberRepository memberRepository() {
            return new DbMemberRepository();
            }
    */
@Configuration //스프링이 시작될 때 해당 클래스를 읽어야함을 의미함
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //memberservice와 memberRepository를 수동으로 bean등록하는 과정
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
