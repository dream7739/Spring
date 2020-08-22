package com.example.board.repository;

import com.example.board.vo.Member;

import java.util.List;


public interface MemberRepository {
    Member save(Member member);
    List<Member> findAll();
}
