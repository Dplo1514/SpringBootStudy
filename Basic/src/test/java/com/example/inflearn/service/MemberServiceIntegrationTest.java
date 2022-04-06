package com.example.inflearn.service;

import com.example.inflearn.domain.Member;
import com.example.inflearn.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//스프링 컨테이너와 함께 실행한다.
@SpringBootTest
//테스트 케이스에 이 Transactional 어노테이션이 있으면 테스트 시작 전에 트랜잭션을 시작하고 테스트 완료 후에 항상 롤백한다.
//이렇게하면 db에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
@Transactional
public class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;



    //멤버 저장테스트
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //중복멤버 저장 예외 테스트
    @Test
    public void validateDuplicateMember() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        //assertThrows(터져야하는 예외의 클래스 , 예외가 터져야하는 행위)
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //try catch를 이용한 exception test
            /*
                    try {
                        memberService.join(member2);
                        fail();
                    }catch (IllegalStateException e){
                        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
                    }
            */

    }

}

