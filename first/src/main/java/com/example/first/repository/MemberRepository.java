package com.example.first.repository;

import com.example.first.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //반환값이 null일 수 있음
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
