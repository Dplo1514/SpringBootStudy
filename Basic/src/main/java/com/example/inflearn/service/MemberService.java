package com.example.inflearn.service;

import com.example.inflearn.domain.Member;
import com.example.inflearn.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//데이터를 조회하고 변경할 때에는 항상 선언해줘야한다.
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public long join(Member member) {
        //같은 이름이있는 중복회원은 안됩니다.
        //파라미터로 가져온 값으로 db의 값을 찾아왔을 때 값이 존재하면 exception을 발생합니다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }
    //전체회원조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //id로 회원 조회
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

    //파라미터로 가져온 값으로 db의 값을 찾아왔을 때 값이 존재하면 exception을 발생합니다.
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
