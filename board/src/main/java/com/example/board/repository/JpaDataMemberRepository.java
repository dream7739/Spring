package com.example.board.repository;

import com.example.board.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
}
