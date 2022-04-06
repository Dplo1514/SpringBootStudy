package com.example.inflearn.repository;

import com.example.inflearn.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    //회원이 저장이된다.
    Member save(Member member);
    //id를 기반으로 회원을 찾아온다
    Optional<Member> findById(Long id);
    //이름을 기반으로 회원을 찾아온다
    Optional<Member> findByName(String name);
    //저장소의 모든 멤버를 찾아 리스트로 만들어준다.
    List<Member> findAll();
}
