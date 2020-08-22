package com.example.board.controller;


import com.example.board.service.MemberService;
import com.example.board.vo.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.board.dto.MemberDto;

import java.util.List;

@Controller
@AllArgsConstructor
public class JoinController {
    private final MemberService memberService;

    @GetMapping("/member/join")
    public String joinMain() {
        return "member/join";
    }

    @PostMapping("/member/join")
    public String createMember(MemberDto memberDto) {
        memberService.createMember(memberDto.toEntity());
        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String memberList(Model model) {
        List<Member> member = memberService.memberList();
        model.addAttribute("members", member);
        return "member/list";
    }
}
