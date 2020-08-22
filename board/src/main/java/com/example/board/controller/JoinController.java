package com.example.board.controller;


import com.example.board.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.board.dto.MemberDto;

@Controller
@AllArgsConstructor
public class JoinController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinMain(){
        return "/join";
    }

    @PostMapping("/join")
    public String createMember(MemberDto memberDto){
        memberService.createMember(memberDto.toEntity());
        return "redirect:/";
    }
}
