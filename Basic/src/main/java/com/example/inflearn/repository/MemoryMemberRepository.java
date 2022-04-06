package com.example.inflearn.repository;

import com.example.inflearn.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//JPA를 extend 하지 않고 JPA의 메서드를 구성한 레포지토리입니다.
public class MemoryMemberRepository implements MemberRepository{

    //db를 대체해서 값이 저장될 임시 저장소
    //save할 때에 저장될 Map 객체를 생성해준다.
    private static Map<Long , Member> store = new HashMap<>();

    //key값을 생성해준다.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        //memeber의 id값을 set해준다.
        member.setId(++sequence);
        //store에 memeber의 id를 set해준다.
        store.put(member.getId() , member);
        //저장된 결과를 반환해준다.
        return  member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //store에서 파라미터 id와 일치하는 id를 찾아와 리턴
        //null가능성이 있기 때문에 optional로 감싸준다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //파라미터로 받아온 name과 store의 name과 같은 이름이 있는지 찾아준다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //store의 값들을 ArrayList에 할당해서 돌려준다.
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
