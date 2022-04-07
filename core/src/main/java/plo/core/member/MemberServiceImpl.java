package plo.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //Appconfig에서 할당해놓은 memberRepository의 구현체를
    //생성자를 통해서 추상체 memberRepository의 구현체를 할당해준다. (생성자 주입)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
