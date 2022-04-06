package com.example.inflearn.service;

import com.example.inflearn.domain.Member;
import com.example.inflearn.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        //멤버변수로 선언한 memberRepository를 MemberService의 인자값으로 할당함으로써
        //테스트코드에서 사용하는 memberRepository에 의존성을 부여한다.
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

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
    public void validateDuplicateMember(){
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

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}