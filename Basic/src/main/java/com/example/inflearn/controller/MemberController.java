package com.example.inflearn.controller;

import com.example.inflearn.domain.Member;
import com.example.inflearn.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //DI : 의존관계 주입
    //spring container에서 memberService에서 찾아서 가져온다.`
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        //$$EnhancerBySpringCGLIB$$119bef8a : proxy를 확인해볼 수 있다.
        //System.out.println("memberService.getClass() = " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createMemberForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
