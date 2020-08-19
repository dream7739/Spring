package com.example.first.controller;

import com.example.first.domain.Member;
import com.example.first.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //@Controller 어노테이션 있으면 스프링 컨테이너에 객체 생성해서 관리 => 스프링 빈 관리
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * 회원가입
     */
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/"; //홈화면으로
    }


    /**
     * 회원조회
     */
    @GetMapping("/members")
    public String list(Model model){
        List<Member> member = memberService.findMembers();
        model.addAttribute("members",member);
        return "members/memberList";
    }
}
