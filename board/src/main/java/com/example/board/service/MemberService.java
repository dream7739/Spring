package com.example.board.service;


import com.example.board.repository.MemberRepository;
import com.example.board.vo.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public void createMember(Member member){
        memberRepository.save(member);
    }

}
