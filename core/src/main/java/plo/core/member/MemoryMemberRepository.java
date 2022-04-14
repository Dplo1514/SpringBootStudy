package plo.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long , Member> store = new HashMap<>();

    @Override
    public void save(Member memeber) {
        store.put(memeber.getId() , memeber);
    }

    @Override
    public Member findById(Long memeberId) {
        return store.get(memeberId);
    }

}
